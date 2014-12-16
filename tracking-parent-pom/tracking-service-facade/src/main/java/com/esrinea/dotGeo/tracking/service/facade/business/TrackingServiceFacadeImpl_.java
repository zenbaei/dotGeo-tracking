package com.esrinea.dotGeo.tracking.service.facade.business;

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
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;
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
import com.esrinea.dotGeo.tracking.service.component.deviceType.DeviceTypeService;
import com.esrinea.dotGeo.tracking.service.component.group.GroupService;
import com.esrinea.dotGeo.tracking.service.component.resource.ResourceService;
import com.esrinea.dotGeo.tracking.service.component.resourceGroup.ResourceGroupService;
import com.esrinea.dotGeo.tracking.service.component.resourceLiveFeed.ResourceLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.sensor.SensorService;
import com.esrinea.dotGeo.tracking.service.component.sensorConfiguration.SensorConfigurationService;
import com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed.SensorLiveFeedService;
import com.esrinea.dotGeo.tracking.service.facade.dataMapper.GeoEventDataExtractor;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

public class TrackingServiceFacadeImpl_ implements TrackingServiceFacade {

	private static Logger LOG = Logger.getLogger(TrackingServiceFacadeImpl_.class);
	private DeviceService deviceService;
	private DeviceTypeService deviceTypeService;
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
	private GeoEventDataExtractor geoEventDataExtractor;
	private Map<Integer, DeviceType> deviceTypesCache = new HashMap<Integer, DeviceType>();// this Map will act as cache of device types
	private Map<Integer, Group> groups;

	@Override
	public void process(GeoEvent geoEvent) {
		deviceFeedReceived(geoEventDataExtractor.extract(geoEvent));
	}

	/*
	 * private void cacheResourcesEffectiveGroups() { List<Resource> resources = resourceService.find(false); for (Resource resource : resources) { List<ResourceGroup> resourceGroups = resourceGroupService.find(resource.getId(), false); if(resourceGroups == null){
	 * 
	 * } resource.setResourceGroups(); if (resresourceGroups == null) {
	 * 
	 * } } }
	 */

	/**
	 * Retrieve all active device types from database along with their active (not retired) sensors, sensors configurations, alerts and alerts configurations then add them to map that will act as a cache for device types .
	 */
	// TODO: refresh on intervals
	// call by init-method in blueprint.xml
	// TODO:add synchronized
	public void cacheDeviceTypesEffectiveConfigurations() {		
		LOG.info("All Device Types will be retrieved and cached.");
		LOG.debug("queryDeviceType method is called to find all device types along with their sensors, sensor configurations, alerts and alert configurations.");

		// get all device types
		for (DeviceType deviceType : deviceTypeService.find(false)) {

			// find and set non retired sensors
			deviceType.setSensors(sensorService.find(deviceType.getId(), false));
			if (deviceType.getSensors() == null) {
				LOG.warn(String.format("Device Type %s has no Sensors. This device type will be escaped.", deviceType));
				continue;// the current deviceType won't be added to deviceTypesCache
			}

			// find and set non retired sensorConfigurations for every sensor
			for (Sensor sensor : deviceType.getSensors()) {
				sensor.setSensorConfigurations(sensorConfigurationService.find(sensor.getId(), false));
				if (sensor.getSensorConfigurations() == null) {
					LOG.warn(String.format("The Sensor %s has no Sensor Configurations. This sensor will be escaped.", sensor));
					continue;
				}
			}

			// find non retired alerts
			List<Alert> alerts = alertService.find(deviceType.getId(), false);
			if (alerts == null) {
				LOG.warn(String.format("Device Type %s has no Alerts.", deviceType));
			} else {
				deviceType.setAlerts(alerts);
			}

			// find non retired alerts configurations
			for (Alert alert : deviceType.getAlerts()) {
				List<AlertConfiguration> alertConfigurations = alertConfigurationService.find(alert.getId(), false);
				if (alertConfigurations == null) {
					LOG.warn(String.format("The Alert %s has no Alert Configurations. This alert will be escaped.", alert));
					continue;
				}
				alert.setAlertConfigurations(alertConfigurations);
			}

			// add deviceType to cached Map
			deviceTypesCache.put(deviceType.getId(), deviceType);
		}

		LOG.info("Device's Types has been retireved and cached.");
		LOG.info("Retrieved Device Types: " + deviceTypesCache);
	}


	public void deviceFeedReceived(EventData eventData) {
		// TODO:remove call from here
		cacheDeviceTypesEffectiveConfigurations();

		LOG.debug("Retrieved Device Types: " + deviceTypesCache);

		LOG.debug("\n--------------------------------------------------------------------------\n" + "PROCESSING DEVICE WITH SERIAL " + eventData.getSerial() + "\n--------------------------------------------------------------------------");

		// TODO: simplify definition
		/**
		 * a set to hold sensor configurations along with their associated newly created sensorLiveFeeds for a specific device's value that passed the configured business rule on that device's type.<br>
		 * This set will be used to check against alerts configuration the newly created sensorLiveFeed is required when inserting into AlertSensorLiveFeed
		 */
		Map<SensorConfiguration, SensorLiveFeed> sensorConfigurationsAssociatedWithNewSensorLiveFeeds = new HashMap<SensorConfiguration, SensorLiveFeed>();

		// find the device with received deviceId, if not found exception will be thrown
		Device device = deviceService.find(eventData.getSerial(), false);

		// insert into resource live feed
		resourceLiveFeedService.create(new ResourceLiveFeed(device, eventData.getFeedDateTime(), eventData.getxCoord(), eventData.getyCoord(), eventData.getSpeed(), eventData.getHeading(), eventData.getZone()));

		// count for device that doesn't have deviceType (error)
		if (device.getDeviceType() == null) {
			LOG.error(String.format("Device with ID %s does not have a Device Type. It has been inserted into Resource Live Feeds and no further processing will occur.", device.getId()));
			return;
		}

		// excluded sensors are eagerly fetched while querying the device
		Map<Sensor, ExecludedSensor> execludedSensors = device.getResource().getExecludedSensors();
		// excluded alerts are eagerly fetched while querying the device
		Map<Alert, ExecludedAlert> execludedAlerts = device.getResource().getExecludedAlerts();

		// if this device's deviceType has no sensors then the deviceType won't exist in the deviceTypeMap
		if (deviceTypesCache.get(device.getDeviceType().getId()) == null) {
			LOG.debug(String.format("Device Type for Device %s has no sensors, the Device data has been added to Resource Live Feeds and no further checks will occur.", device));
			return;
		}

		LOG.debug("\n---------------------------\nPROCESSING SENSORS BEGINS\n---------------------------");
		// check if deviceType's sensors are not excluded from that device
		OUTER: for (Sensor sensor : deviceTypesCache.get(device.getDeviceType().getId()).getSensors()) {// loop on deviceType's sensors, for instance TEMP sensor
			LOG.debug(String.format("\n---------------------------\nCHECKING %s SENSOR\n---------------------------", sensor.getNameEn().toUpperCase()));
			if (!execludedSensors.containsKey(sensor)) {// ex; TEMP sensor is active on that device,
				if (sensor.getSensorConfigurations() == null || sensor.getSensorConfigurations().isEmpty()) {
					LOG.warn(String.format("The Sensor %s has no Sensor Configurations. This sensor will be escaped.", sensor));
					continue;
				}

				Object sensorValue = eventData.getSensorValuesWithKeyCapitalized().get(sensor.getNameEn().toUpperCase());// get received sensor value from EventData's sensorValues Map using cached deviceType sensors' name, it should be saved as TEMP key and the received value
				if (sensorValue == null) { // count for an input stream that was configured to send some of the deviceType's sensors
					LOG.warn(String.format("Device Type with ID %s defined to has a Sensor with the name of %s, but no data was received for this Sensor.", device.getDeviceType().getId(), sensor.getNameEn().toUpperCase()));
					continue;
				}

				for (SensorConfiguration sensorConfiguration : sensor.getSensorConfigurations()) { // loop on deviceType sensor's sensorConfiguration, TEMP sensor configuration has 3 configurations (LOW,MED,HIGH)
					if (sensorConfigurationService.isBusinessRuleSatisfiedDelegate(sensorConfiguration, sensorValue)) {// received sensor value fall under the business rule, the 3 TEMP sensor configurations will be checked against the received value
						SensorLiveFeed sensorLiveFeed = new SensorLiveFeed(device, sensorConfiguration, String.valueOf(sensorValue), eventData.getFeedDateTime()); // insert SensorLiveFeed into Database
						sensorLiveFeedService.create(sensorLiveFeed);
						sensorConfigurationsAssociatedWithNewSensorLiveFeeds.put(sensorLiveFeed.getSensorConfiguration(), sensorLiveFeed); // keep sensor configurations that fall under the business rule
						continue OUTER; // if reached then one sensor configuration of a specific sensor has succeed then move to the next sensor (ex; Temp sensor has 3 configurations: High, Medium and Low. Definity Temp sensor value with be either be High, Medium or Low
					}
				}
			} else {
				LOG.warn(String.format("The Sensor %s is excluded.", sensor.getNameEn().toUpperCase()));
			}
		}
		LOG.debug("\n---------------------------\nPROCESSING SENSORS ENDS\n---------------------------");

		LOG.debug("\n---------------------------\nPROCESSING ALERTS BEGINS\n---------------------------");
		if (deviceTypesCache.get(device.getDeviceType().getId()).getAlerts() == null) {
			LOG.debug(String.format("Device Type for Device %s has no alerts, the Device data has been added to Resource Live Feeds and Sensor Live Feeds and no further checks will occur.", device));
			LOG.debug("\n---------------------------\nPROCESSING ALERTS ENDS\n---------------------------");
			return;
		}

		// check if deviceType's alerts are not excluded from that device
		OUTER: for (Alert alert : deviceTypesCache.get(device.getDeviceType().getId()).getAlerts()) {// loop on deviceType's alerts
			LOG.debug(String.format("\n---------------------------\nCHECKING %s ALERT\n---------------------------", alert.getNameEn().toUpperCase()));
			if (!execludedAlerts.containsKey(alert)) {// alert is active on that device
				if (alert.getAlertConfigurations() == null || alert.getAlertConfigurations().isEmpty()) {
					LOG.warn(String.format("The %s has no Alert Configurations. This alert will be escaped.", alert));
					continue;
				}

				for (AlertConfiguration alertConfiguration : alert.getAlertConfigurations()) {// loop on deviceType alert's alertConfiguration, compound alerts will have more than configuration that group sensor configurations together, for instance OIL level is low and TEMP is 50
					LOG.debug("Checking " + alertConfiguration.getSensorConfiguration());
					// check if the Alert Configuration configured on the device's DeviceType has its sensorConfiguration //TODO: complete description
					if (sensorConfigurationsAssociatedWithNewSensorLiveFeeds.containsKey(alertConfiguration.getSensorConfiguration())) {// an alert could be compound(hold more than a rule) if one rule is not satisfied then move to next alert
						LOG.debug(String.format("Alert configuration passed on Alert %s.", alert.getNameEn().toUpperCase()));
						continue;// as long as rules are included in the current alert then continue checking
					} else {
						LOG.debug(String.format("Sensor configuration failed on Alert %s.", alert.getNameEn().toUpperCase()));
						LOG.debug(String.format("Alert %s will be discarded.", alert.getNameEn().toUpperCase()));
						continue OUTER;// if a rule isn't included then ignore the current alert and check the next alert
					}
				}

				// if this line is reached then all alertConfiguration in an alert had their rules satisfied
				AlertLiveFeed alertLiveFeed = new AlertLiveFeed(device, alert, eventData.getFeedDateTime(), eventData.getZone(), eventData.getxCoord(), eventData.getyCoord());// insert AlertLiveFeed only if all rules in an alert is satisfied
				alertLiveFeedService.create(alertLiveFeed);
				LOG.debug(String.format("\n----------------------------------------------\nALERT %s HAS SUCCEEDED\n----------------------------------------------", alert.getNameEn().toUpperCase()));

				// TODO:simply definition + re check whether to use alertLiveFeed or use Alert directly or other
				// create AlertSensorLiveFeed, use the newly created alertLiveFeed to get its Alert and then its AlertConfiguration and then its SensorConfigurations
				for (AlertConfiguration alertConfiguration : alert.getAlertConfigurations()) {
					AlertSensorLiveFeed alertSensorLiveFeed = new AlertSensorLiveFeed(new AlertSensorLiveFeedId(alertLiveFeed.getId(), sensorConfigurationsAssociatedWithNewSensorLiveFeeds.get(alertConfiguration.getSensorConfiguration()).getId()));
					alertSensorLiveFeedService.create(alertSensorLiveFeed);
				}
			} else {
				LOG.warn(String.format("The Alert %s is excluded.", alert.getNameEn().toUpperCase()));
			}
		}
		LOG.debug("\n---------------------------\nPROCESSING ALERTS ENDS\n---------------------------");

		LOG.debug("\n--------------------------------------------------------------------------\n" + "PROCESSING DEVICE COMPLETED\n" + "--------------------------------------------------------------------------");
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

	public void setDeviceTypeService(DeviceTypeService deviceTypeService) {
		this.deviceTypeService = deviceTypeService;
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
}
