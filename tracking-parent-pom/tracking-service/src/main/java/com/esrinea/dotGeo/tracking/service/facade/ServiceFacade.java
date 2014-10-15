package com.esrinea.dotGeo.tracking.service.facade;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity.AlertLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;
import com.esrinea.dotGeo.tracking.service.component.alert.AlertService;
import com.esrinea.dotGeo.tracking.service.component.alertConfiguration.AlertConfigurationService;
import com.esrinea.dotGeo.tracking.service.component.alertLiveFeed.AlertLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;
import com.esrinea.dotGeo.tracking.service.component.deviceType.DeviceTypeService;
import com.esrinea.dotGeo.tracking.service.component.helper.EventData;
import com.esrinea.dotGeo.tracking.service.component.sensor.SensorService;
import com.esrinea.dotGeo.tracking.service.component.sensorConfiguration.SensorConfigurationService;
import com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed.SensorLiveFeedService;

@Transactional(propagation = Propagation.REQUIRED)
public class ServiceFacade {

	private static Logger LOG = Logger.getLogger(ServiceFacadeTest.class);
	private DeviceService deviceService;
	private DeviceTypeService deviceTypeService;
	private SensorService sensorService;
	private SensorConfigurationService sensorConfigurationService;
	private AlertService alertService;
	private AlertLiveFeedService alertLiveFeedService;
	private AlertConfigurationService alertConfigurationService;
	private SensorLiveFeedService sensorLiveFeedService;
	private Map<Integer, DeviceType> deviceTypesCache = new HashMap<Integer, DeviceType>();// this Map will act as cache of device types

	/**
	 * Retrieve all active device types from database along with their active (not retired) sensors, sensors configurations, alerts and alerts configurations then add them to map that will act as a cache for device types .
	 */
	public void buildDeviceType() {

		// get all device types
		for (DeviceType deviceType : deviceTypeService.findAll(false)) {

			// find and set non retired sensors
			deviceType.setSensors(sensorService.find(deviceType.getId(), false));

			// find and set non retired sensorConfigurations for every sensor
			for (Sensor sensor : deviceType.getSensors()) {
				sensor.setSensorConfigurations(sensorConfigurationService.find(sensor.getId(), false));
			}

			// find non retired alerts
			deviceType.setAlerts(alertService.find(deviceType.getId(), false));

			// find non retired alerts configurations
			for (Alert alert : deviceType.getAlerts()) {
				alert.setAlertConfigurations(alertConfigurationService.find(alert.getId(), false));
			}

			// add deviceType to cached Map
			deviceTypesCache.put(deviceType.getId(), deviceType);
		}
	}

	public void deviceFeedRecieved(EventData eventData) {

		// a set to keep each sensor configuration that fall under the business rule in a list to see if it has an alert on it later when checking deviceType alerts' alertConfigurations
		// to avoid doing same check twice(when examining received sensor data against deviceType's sensor configuration and secondly when checking deviceType's sensor configuration against alert configurations)
		Set<SensorConfiguration> sensorConfigurationsPassedBusinessRule = new HashSet<SensorConfiguration>();

		// find the device with received deviceId
		Device device = deviceService.find(eventData.getDeviceId(), false);
		// insert into resource live feed
		ResourceLiveFeed resourceLiveFeed = new ResourceLiveFeed(device, eventData.getFeedDateTime(), eventData.getxCoord(), eventData.getyCoord(), eventData.getSpeed(), eventData.getHeading(), eventData.getZone());

		// get device type for that device from cached Map
		DeviceType deviceType = deviceTypesCache.get(device.getDeviceType().getId());

		// excluded sensors are eagerly fetched while querying the device
		Map<Sensor, ExecludedSensor> execludedSensors = device.getResource().getExecludedSensors();
		// excluded alerts are eagerly fetched while querying the device
		Map<Alert, ExecludedAlert> execludedAlerts = device.getResource().getExecludedAlerts();

		// check if deviceType's sensors are not excluded from that device
		for (Sensor sensor : deviceType.getSensors()) {// loop on deviceType's sensors
			if (!execludedSensors.containsKey(sensor)) {// sensor is active on that device
				for (SensorConfiguration sensorConfiguration : sensor.getSensorConfigurations()) { // loop on deviceType sensor's sensorConfiguration
					String sensorValue = eventData.getSensorValues().get(sensor.getNameEn());//TODO: sensorValue is now string while it could be double
					if (sensorConfigurationService.isBusinessRuleSatisfied(sensorConfiguration, sensorValue)) {// received sensor value fall under the business rule
						sensorLiveFeedService.create(new SensorLiveFeed(device, sensorConfiguration, String.valueOf(sensorValue), eventData.getFeedDateTime())); // insert SensorLiveFeed into Database
						sensorConfigurationsPassedBusinessRule.add(sensorConfiguration); // keep sensor configurations that fall under the business rule
					}
				}

			}
		}

		// check if deviceType's alerts are not excluded from that device
		for (Alert alert : deviceType.getAlerts()) {// loop on deviceType's alerts
			if (!execludedAlerts.containsKey(alert)) {// alert is active on that device
				for (AlertConfiguration alertConfiguration : alert.getAlertConfigurations()) {// loop on deviceType alert's alertConfiguration
					if (sensorConfigurationsPassedBusinessRule.contains(alertConfiguration.getSensorConfiguration())) {// an alert is set on that sensor configuration
						alertLiveFeedService.create(new AlertLiveFeed(device, alert, eventData.getFeedDateTime(), eventData.getZone()));// insert AlertLiveFeed into database.
					}
				}
			}
		}

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

}
