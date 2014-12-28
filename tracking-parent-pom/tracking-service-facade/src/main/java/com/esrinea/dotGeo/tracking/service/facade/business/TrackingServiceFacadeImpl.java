package com.esrinea.dotGeo.tracking.service.facade.business;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.esri.ges.core.geoevent.GeoEvent;
import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity.AlertLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity.AlertSensorLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity.AlertSensorLiveFeedId;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.sensorType.entity.SensorType;
import com.esrinea.dotGeo.tracking.service.component.alert.AlertService;
import com.esrinea.dotGeo.tracking.service.component.alertConfiguration.AlertConfigurationService;
import com.esrinea.dotGeo.tracking.service.component.alertLiveFeed.AlertLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.alertSensorLiveFeed.AlertSensorLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;
import com.esrinea.dotGeo.tracking.service.component.fence.FenceService;
import com.esrinea.dotGeo.tracking.service.component.group.GroupService;
import com.esrinea.dotGeo.tracking.service.component.resource.ResourceService;
import com.esrinea.dotGeo.tracking.service.component.resourceGroup.ResourceGroupService;
import com.esrinea.dotGeo.tracking.service.component.resourceLiveFeed.ResourceLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.sensor.SensorService;
import com.esrinea.dotGeo.tracking.service.component.sensorConfiguration.SensorConfigurationService;
import com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed.SensorLiveFeedService;
import com.esrinea.dotGeo.tracking.service.facade.dataMapper.GeoEventDataExtractor;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

public class TrackingServiceFacadeImpl implements TrackingServiceFacade {

	private static Logger LOG = Logger.getLogger(TrackingServiceFacadeImpl.class);
	private DeviceService deviceService;
	private ResourceLiveFeedService resourceLiveFeedService;
	private SensorService sensorService;
	private SensorConfigurationService sensorConfigurationService;
	private AlertService alertService;
	private AlertLiveFeedService alertLiveFeedService;
	private AlertConfigurationService alertConfigurationService;
	private AlertSensorLiveFeedService alertSensorLiveFeedService;
	private SensorLiveFeedService sensorLiveFeedService;
	private GroupService groupService;
	private ResourceService resourceService;
	private ResourceGroupService resourceGroupService;
	private FenceService fenceService;
	private GeoEventDataExtractor geoEventDataExtractor;
	private String gdbDatasource;
	private String featureFieldName;
	private volatile Map<String, Device> devicesCache = new HashMap<String, Device>();// this Map will act as cache of devices, using Serial as key

	@Override
	public void process(GeoEvent geoEvent) throws Exception {
		deviceFeedReceived(geoEventDataExtractor.extract(geoEvent));
	}

	/**
	 * 
	 * Retrieve all active devices along with active deviceTypes and active (not retired) sensors, sensors configurations,<br>
	 * alerts and alerts configurations, resources and its groups then add them to map that will act as a cache for devices.
	 * 
	 */
	// TODO: refresh on intervals
	// called by init-method in blueprint.xml
	// TODO:add synchronized
	public synchronized void initializeCache() {
		LOG.info("initializeCache is called. All active devices along with its tree will be cached.");

		List<Device> devices = deviceService.findAndFetchDeviceType(false);

		if (devices == null || devices.isEmpty()) {
			LOG.warn("No active devices were found.");
			return;
		}

		LOG.info("Retrieved Devices are:");
		for (Device device : devices) {
			LOG.info(String.format("Device with Serial %s", device.getSerial()));
		}

		for (Device device : devices) {
			if (device.getDeviceType() != null && !device.getDeviceType().isRetired()) {// count for deviceType mistakenly set to retired.
				setActiveResource(device);// Get resources first to check for excludedSensor and excludedAlerts in setDeviceTypeActiveSensors and setDeviceTypeActiveAlerts respectively.
				setActiveSensors(device);
				if (device.getDeviceType().getSensors() == null || device.getDeviceType().getSensors().isEmpty()) {// if no active sensors.
					LOG.warn(String.format("Device with Serial %s has no sensors and thus no further retrieving of Aletrs will be done.", device.getSerial()));
					devicesCache.put(device.getSerial(), device);// this device data will be used only with tracking live feeds.
					continue;// then escape checking its Alerts.
				}
				setActiveAlerts(device);// even if deviceType doesn't have Alerts its live sensors feed will be used.
				devicesCache.put(device.getSerial(), device);
				LOG.info(String.format("Device with Serial %s and Device Type of %s is active.", device.getSerial(), device.getDeviceType().getDesc()));
			}
		}
		LOG.info("Devices have been retireved and cached.");
	}

	/**
	 * Only Alerts that have non retired AlertConfigrations will be added.
	 * 
	 * @param device
	 */
	private void setActiveAlerts(Device device) {
		LOG.info(String.format("Checking Active Alerts along with its active AlertConfigurations for Device Type %s.", device.getDeviceType().getDesc()));
		// find non retired alerts
		List<Alert> alerts = alertService.find(device.getDeviceType().getId(), false);
		if (alerts == null || alerts.isEmpty()) {
			LOG.warn(String.format("Device Type %s has no Alerts.", device.getDeviceType().getDesc()));
			return;
		}

		// find non retired alerts configurations
		for (Alert alert : alerts) {
			// its valid to have a device without a resource.
			if (device.getResource() != null && device.getResource().getExecludedAlerts() != null && device.getResource().getExecludedAlerts().containsKey(alert)) {
				LOG.info(String.format("Alert %s is excluded on Device with Serial %s.", alert.getNameEn(), device.getSerial()));
				continue;
			}
			alert.setAlertConfigurations(alertConfigurationService.find(alert.getId(), false));
			if (alert.getAlertConfigurations() == null || alert.getAlertConfigurations().isEmpty()) {
				LOG.warn(String.format("The Alert %s has no Alert Configurations. This alert will be escaped.", alert.getNameEn()));
				continue;
			}
			device.getDeviceType().addAlert(alert);
			LOG.debug(String.format("Alert %s is valid.", alert.getNameEn()));
		}

	}

	/**
	 * Only active Sensors along with its active SensorConfigurations will be added.
	 * 
	 * @param device
	 */
	private void setActiveSensors(Device device) {
		LOG.info(String.format("Checking Active Sensors along with its active SensorConfigurations for Device Type %s.", device.getDeviceType().getDesc()));
		// find non retired sensors
		List<Sensor> sensors = sensorService.find(device.getDeviceType().getId(), false);

		// if no sensors then ignore this deviceType
		if (sensors == null || sensors.isEmpty()) {
			LOG.warn(String.format("Device Type %s has no Sensors. This device type will be escaped.", device.getDeviceType().getDesc()));
			return;// the current device won't be added to devicesCache
		}

		// find and set non retired sensorConfigurations for every sensor
		for (Sensor sensor : sensors) {
			// check excluded sensors. its valid to have a device without a resource.
			if (device.getResource() != null && device.getResource().getExecludedSensors() != null && device.getResource().getExecludedSensors().containsKey(sensor)) {
				LOG.info(String.format("Sensor %s is excluded on Device with Serial %s.", sensor.getNameEn(), device.getSerial()));
				continue;
			}
			sensor.setSensorConfigurations(sensorConfigurationService.find(sensor.getId(), false));
			if (sensor.getSensorConfigurations() == null || sensor.getSensorConfigurations().isEmpty()) {
				LOG.warn(String.format("The Sensor %s has no Sensor Configurations. This sensor will be escaped.", sensor.getNameEn()));
				continue;
			}
			device.getDeviceType().addSensor(sensor);
			LOG.debug(String.format("Sensor %s is valid.", sensor.getNameEn()));
		}
	}

	/**
	 * Steps are:<br>
	 * 1- Retrieve Resources (non retired, excluded sensors and alerts are eagerly fetched as they have no retired flag).<br>
	 * 2- Retrieve ResouceGroups(non retired) by Resource ID.<br>
	 * 3- Retrieve Groups(non retired, not null fenceLayer as it's the main reason for caching the Resource) by Group ID.
	 * 
	 * @param device
	 */
	private void setActiveResource(Device device) {
		LOG.info(String.format("Checking Active Resources along with its Groups for Device with Serial %s.", device.getSerial()));

		try {
			device.setResource(resourceService.find(device.getId(), false));
		} catch (Exception ex) { // NonUniqueResultException | NoResultException
			LOG.info(String.format("Device with Serial %s has no Resource nevertheless it's a valid device.", device.getSerial()));
			return;
		}

		List<ResourceGroup> resourceGroups = resourceGroupService.find(device.getResource().getId(), false);

		if (resourceGroups == null || resourceGroups.isEmpty()) {
			LOG.info(String.format("Device with serial %s doesn't belong to a group or its group is retired.", device.getSerial()));
		}

		if (resourceGroups != null) {
			for (ResourceGroup resourceGroup : resourceGroups) {
				resourceGroup.setGroup(groupService.findByNotNullFenceLayer(resourceGroup.getGroup().getId(), false));
				if (resourceGroup.getGroup() != null) {// Only interested in groups that has fence, thus if it doesn't then no need to cache it.
					resourceGroup.getGroup().setFences(fenceService.find(resourceGroup.getGroup().getId(), false));// retrieve fences
					if (resourceGroup.getGroup().getFences() != null && !resourceGroup.getGroup().getFences().isEmpty()) {// only interested in groups that have active fences
						device.getResource().addResourceGroup(resourceGroup);
						LOG.debug(String.format("Resource with ID of %s and Device with Serial %s belong to %s Group.", device.getResource().getId(), device.getSerial(), resourceGroup.getGroup().getDescEn()));
					}
				}
			}
		}
	}

	/**
	 * Device will only exist in cache if it has an active deviceType and sensorConfigurations.
	 * 
	 * @throws Exception
	 */
	public void deviceFeedReceived(EventData eventData) throws Exception {
		LOG.debug("\n--------------------------------------------------------------------------\n" + "PROCESSING DEVICE WITH SERIAL " + eventData.getSerial() + "\n--------------------------------------------------------------------------");

		// TODO: simplify definition
		/**
		 * a set to hold sensor configurations along with their associated newly created sensorLiveFeeds for a specific device's value that passed the configured business rule on that device's type.<br>
		 * This set will be used to check against alerts configuration the newly created sensorLiveFeed is required when inserting into AlertSensorLiveFeed
		 */
		Map<SensorConfiguration, SensorLiveFeed> sensorConfigurationsAssociatedWithNewSensorLiveFeeds = new HashMap<SensorConfiguration, SensorLiveFeed>();

		Device device = devicesCache.get(eventData.getSerial());

		// device doesn't exist in cache
		if (device == null) {
			LOG.warn(String.format("Device with Serial %s is either retired or its device type is retired or doesn't exist in DB.", eventData.getSerial()));
			LOG.debug("\n--------------------------------------------------------------------------\n" + "PROCESSING DEVICE COMPLETED\n" + "--------------------------------------------------------------------------");
			return;
		}

		// insert into resource live feed
		resourceLiveFeedService.create(new ResourceLiveFeed(device, eventData.getFeedDateTime(), eventData.getxCoord(), eventData.getyCoord(), eventData.getSpeed(), eventData.getHeading(), eventData.getZone()));

		executeSensors(device, eventData, sensorConfigurationsAssociatedWithNewSensorLiveFeeds);

		executeAlerts(device, eventData, sensorConfigurationsAssociatedWithNewSensorLiveFeeds);

		LOG.debug("\n--------------------------------------------------------------------------\n" + "PROCESSING DEVICE COMPLETED\n" + "--------------------------------------------------------------------------");
	}

	private void executeSensors(Device device, EventData eventData, Map<SensorConfiguration, SensorLiveFeed> sensorConfigurationsAssociatedWithNewSensorLiveFeeds) throws Exception {
		LOG.debug("\n---------------------------\nPROCESSING SENSORS BEGINS\n---------------------------");

		if (device.getDeviceType().getSensors() == null || device.getDeviceType().getSensors().isEmpty()) {
			LOG.warn(String.format("Device with Serial %s has no sensors.", device.getSerial()));
			LOG.debug("\n---------------------------\nPROCESSING SENSORS ENDS\n---------------------------");
			return;
		}

		// check if deviceType's sensors are not excluded from that device
		OUTER: for (Sensor sensor : device.getDeviceType().getSensors()) {// loop on deviceType's sensors, for instance TEMP sensor
			LOG.debug(String.format("\n---------------------------\nCHECKING %s SENSOR FOR DEVICE WITH SERIAL %s\n---------------------------", sensor.getNameEn().toUpperCase(), device.getSerial()));

			Object sensorValue = eventData.getSensorValuesWithKeyCapitalized().get(sensor.getNameEn().toUpperCase());// get received sensor value from EventData's sensorValues Map using cached deviceType sensors' name, it should be saved as TEMP for key and the received value
			if (sensorValue == null) { // count for an input stream that was configured to send some of the deviceType's sensors
				if (sensor.getSensorType() != null && sensor.getSensorType().getDescription() != null && !sensor.getSensorType().getDescription().isEmpty() && sensor.getSensorType().getDescription().equals(SensorType.Type.GeoFence.toString())) {
					executeGeoFenceSensor(device, eventData, sensor, sensorConfigurationsAssociatedWithNewSensorLiveFeeds);
					continue;// check next sensor
				}
				LOG.warn(String.format("Device Type with ID %s defined to has a Sensor with the name of %s, but no data was received for this Sensor.", device.getDeviceType().getId(), sensor.getNameEn().toUpperCase()));
				LOG.debug(String.format("\n---------------------------\nSENSOR %s HAS FAILED\n---------------------------", sensor.getNameEn().toUpperCase()));
				continue;
			}

			for (SensorConfiguration sensorConfiguration : sensor.getSensorConfigurations()) { // loop on deviceType sensor's sensorConfiguration, TEMP sensor configuration has 3 configurations (LOW,MED,HIGH)
				if (sensorConfigurationService.isBusinessRuleSatisfiedDelegate(sensorConfiguration, sensorValue)) {// received sensor value fall under the business rule, the 3 TEMP sensor configurations will be checked against the received value
					SensorLiveFeed sensorLiveFeed = new SensorLiveFeed(device, sensorConfiguration, String.valueOf(sensorValue), eventData.getFeedDateTime()); // insert SensorLiveFeed into Database
					sensorLiveFeedService.create(sensorLiveFeed);
					sensorConfigurationsAssociatedWithNewSensorLiveFeeds.put(sensorLiveFeed.getSensorConfiguration(), sensorLiveFeed); // keep sensor configurations that fall under the business rule
					continue OUTER; // if reached then one sensor configuration of a specific sensor has succeed then move to the next sensor (ex; Temp sensor has 3 configurations: High, Medium and Low. Definitely Temp sensor value(one input value) would be either High, Medium or Low
				}
			}

		}
		LOG.debug("\n---------------------------\nPROCESSING SENSORS ENDS\n---------------------------");
	}

	private void executeGeoFenceSensor(Device device, EventData eventData, Sensor geoFenceSensor, Map<SensorConfiguration, SensorLiveFeed> sensorConfigurationsAssociatedWithNewSensorLiveFeeds) throws Exception {
		LOG.debug(String.format("Processing GeoFence Sensor on Device with Serial %s.", device.getSerial()));

		if (device.getResource() == null || device.getResource().getResourceGroups() == null || device.getResource().getResourceGroups().isEmpty()) {
			LOG.info(String.format("Device with serial %s doesn't belong to a group or its group is retired.", device.getSerial()));
			LOG.debug("\n---------------------------\nGEOFENCE SENSOR CHECKING COMPLETED\n---------------------------");
			return;
		}

		for (ResourceGroup resourceGroup : device.getResource().getResourceGroups()) {
			LOG.debug(String.format("Processing Group %s.", resourceGroup.getGroup().getDescEn()));
			for (Fence fence : resourceGroup.getGroup().getFences()) {
				LOG.debug(String.format("\n---------------------------\n   GROUP %s SHOULD BE %s FENCE WITH ID OF %s\n---------------------------", resourceGroup.getGroup().getDescEn(), fence.getRule().toUpperCase(), fence.getFenceId()));
				try {
					boolean inFence = fenceService.intersect(fence, gdbDatasource, featureFieldName, eventData.getxCoord(), eventData.getyCoord());

					SensorLiveFeed sensorLiveFeed = null;
					SensorConfiguration sensorConfiguration = null;

					if (inFence) {
						sensorConfiguration = getGeoFenceSensorConfiguration(geoFenceSensor.getSensorConfigurations(), "in");
					} else {
						sensorConfiguration = getGeoFenceSensorConfiguration(geoFenceSensor.getSensorConfigurations(), "out");
					}

					if (sensorConfiguration == null) {
						LOG.error("GeoFence Sensor has no sensorConfigurations while it is mandatory in order to fill Sensor Live Feeds. This sensor will be discarded.");
						LOG.debug("\n---------------------------\nGEOFENCE SENSOR CHECKING COMPLETED\n---------------------------");
						return;
					}

					LOG.debug(String.format("\n---------------------------\n   GROUP %s IS %s FENCE WITH ID %s\n---------------------------", resourceGroup.getGroup().getDescEn(), sensorConfiguration.getTextValue().toUpperCase(), fence.getFenceId()));

					sensorLiveFeed = new SensorLiveFeed(device, sensorConfiguration, String.format("%s#%s#%s", resourceGroup.getGroup().getFenceLayer().getId(), fence.getFenceId(), fence.getRule()), eventData.getFeedDateTime());
					sensorLiveFeedService.create(sensorLiveFeed);
					// TODO:simplify
					// add to map only when intersect result is not as supposed(as alerts checks on them later and we don't want to report true ones.
					if (inFence != fence.getRule().equalsIgnoreCase("in") ? true : false) {
						sensorConfigurationsAssociatedWithNewSensorLiveFeeds.put(sensorLiveFeed.getSensorConfiguration(), sensorLiveFeed);
					}
				} catch (IOException e) {
					LOG.error(String.format("Unable to Open gdb datasource %s.\n%s", gdbDatasource), e);
				} catch (IllegalStateException ex) {
					LOG.info(ex.getMessage());
					LOG.debug(String.format("\n---------------------------\n   FENCE WITH ID %s DOES NOT EXIST IN GIS DATASOURCE\n---------------------------", fence.getFenceId()));
				}
			}
		}
		LOG.debug("\n---------------------------\nGEOFENCE SENSOR CHECKING COMPLETED\n---------------------------");
	}

	private SensorConfiguration getGeoFenceSensorConfiguration(List<SensorConfiguration> sensorConfigurations, String type) {
		// set sensorConfiguarion with in and out value
		for (SensorConfiguration sensorConfiguration : sensorConfigurations) {
			if (sensorConfiguration.getTextValue() == null || sensorConfiguration.getTextValue().isEmpty()) {
				return null;
			}
			if (sensorConfiguration.getTextValue().equalsIgnoreCase(type)) {
				return sensorConfiguration;
			}
		}
		return null;
	}

	private void executeAlerts(Device device, EventData eventData, Map<SensorConfiguration, SensorLiveFeed> sensorConfigurationsAssociatedWithNewSensorLiveFeeds) throws Exception {
		LOG.debug("\n---------------------------\nPROCESSING ALERTS BEGINS\n---------------------------");

		if (device.getDeviceType().getAlerts() == null || device.getDeviceType().getAlerts().isEmpty()) {
			LOG.warn(String.format("Device with Serial %s has no alerts.", device.getSerial()));
			LOG.debug("\n---------------------------\nPROCESSING ALERTS ENDS\n---------------------------");
			return;
		}

		// check if deviceType's alerts are not excluded from that device
		OUTER: for (Alert alert : device.getDeviceType().getAlerts()) {// loop on deviceType's alerts
			LOG.debug(String.format("\n---------------------------\nCHECKING %s ALERT FOR DEVICE WITH SERIAL %s\n---------------------------", alert.getNameEn().toUpperCase(), device.getSerial()));
			String sensorTypeId = null;
			String geoFenceLayerIdAndFenceId = null;

			for (AlertConfiguration alertConfiguration : alert.getAlertConfigurations()) {// loop on deviceType alert's alertConfiguration, compound alerts will have more than configuration that group sensor configurations together, for instance OIL level is low and TEMP is 50
				LOG.debug(String.format("Checking %s", alertConfiguration.getSensorConfiguration()));

				// check if the Alert Configuration configured on the device's DeviceType has its sensorConfiguration //TODO: complete description
				if (sensorConfigurationsAssociatedWithNewSensorLiveFeeds.containsKey(alertConfiguration.getSensorConfiguration())) {// an alert could be compound(hold more than a rule) if one rule is not satisfied then move to next alert
					LOG.debug(String.format("Alert configuration passed on Alert %s.", alert.getNameEn().toUpperCase()));
					// for GeoFence keep sensorTypeId and geoFenceLayerIdAndFenceId in order to insert it when creating AlertLiveFeed
					SensorLiveFeed sensorLiveFeed = sensorConfigurationsAssociatedWithNewSensorLiveFeeds.get(alertConfiguration.getSensorConfiguration());
					if (sensorLiveFeed.getSensorConfiguration().getSensor().getSensorType() != null && !sensorLiveFeed.getSensorConfiguration().getSensor().getSensorType().getDescription().isEmpty()
							&& sensorLiveFeed.getSensorConfiguration().getSensor().getSensorType().getDescription().equalsIgnoreCase(SensorType.Type.GeoFence.toString())) {
						// TODO: add description
						sensorTypeId = String.valueOf(sensorLiveFeed.getSensorConfiguration().getSensor().getSensorType().getId());
						geoFenceLayerIdAndFenceId = sensorLiveFeed.getSensorValue();
					}
					continue;// as long as rules are included in the current alert then continue checking
				} else {
					LOG.debug(String.format("Sensor configuration failed on Alert %s.", alert.getNameEn().toUpperCase()));
					LOG.debug(String.format("Alert %s will be discarded.", alert.getNameEn().toUpperCase()));
					LOG.debug(String.format("\n---------------------------\nALERT %s HAS FAILED\n---------------------------", alert.getNameEn().toUpperCase()));
					continue OUTER;// if a rule isn't included then ignore the current alert and check the next alert
				}
			}

			// if this line is reached then all alertConfiguration in an alert had their rules satisfied
			AlertLiveFeed alertLiveFeed = new AlertLiveFeed(device, alert, eventData.getFeedDateTime(), eventData.getZone(), eventData.getxCoord(), eventData.getyCoord(), sensorTypeId, geoFenceLayerIdAndFenceId);// insert AlertLiveFeed only if all rules in an alert are satisfied
			alertLiveFeedService.create(alertLiveFeed);
			LOG.debug(String.format("\n----------------------------------------------\nALERT %s HAS SUCCEEDED\n----------------------------------------------", alert.getNameEn().toUpperCase()));

			// TODO:simply definition + re check whether to use alertLiveFeed or use Alert directly or other
			// create AlertSensorLiveFeed, use the newly created alertLiveFeed to get its Alert and then its AlertConfiguration and then its SensorConfigurations
			for (AlertConfiguration alertConfiguration : alert.getAlertConfigurations()) {
				AlertSensorLiveFeed alertSensorLiveFeed = new AlertSensorLiveFeed(new AlertSensorLiveFeedId(alertLiveFeed.getId(), sensorConfigurationsAssociatedWithNewSensorLiveFeeds.get(alertConfiguration.getSensorConfiguration()).getId()));
				alertSensorLiveFeedService.create(alertSensorLiveFeed);
			}
		}
		LOG.debug("\n---------------------------\nPROCESSING ALERTS ENDS\n---------------------------");
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	public void setSensorConfigurationService(SensorConfigurationService sensorConfigurationService) {
		this.sensorConfigurationService = sensorConfigurationService;
	}

	public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}

	public void setAlertConfigurationService(AlertConfigurationService alertConfigurationService) {
		this.alertConfigurationService = alertConfigurationService;
	}

	public void setResourceLiveFeedService(ResourceLiveFeedService resourceLiveFeedService) {
		this.resourceLiveFeedService = resourceLiveFeedService;
	}

	public void setSensorLiveFeedService(SensorLiveFeedService sensorLiveFeedService) {
		this.sensorLiveFeedService = sensorLiveFeedService;
	}

	public void setAlertLiveFeedService(AlertLiveFeedService alertLiveFeedService) {
		this.alertLiveFeedService = alertLiveFeedService;
	}

	public void setAlertSensorLiveFeedService(AlertSensorLiveFeedService alertSensorLiveFeedService) {
		this.alertSensorLiveFeedService = alertSensorLiveFeedService;
	}

	public void setGeoEventDataExtractor(GeoEventDataExtractor geoEventDataExtractor) {
		this.geoEventDataExtractor = geoEventDataExtractor;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setResourceGroupService(ResourceGroupService resourceGroupService) {
		this.resourceGroupService = resourceGroupService;
	}

	public void setFenceService(FenceService fenceService) {
		this.fenceService = fenceService;
	}

	public void setGdbDatasource(String gdbDatasource) {
		this.gdbDatasource = gdbDatasource;
	}

	public void setFeatureFieldName(String featureFieldName) {
		this.featureFieldName = featureFieldName;
	}
}
