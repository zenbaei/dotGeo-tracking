package com.esrinea.dotGeo.tracking.service.component.senario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;
import com.esrinea.dotGeo.tracking.service.component.resourceLiveFeed.ResourceLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.sensor.SensorService;
import com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed.SensorLiveFeedService;

public class SenariosTest extends DeviceServiceTest {

	private static Logger LOG = Logger.getLogger(SenariosTest.class);
	@Autowired
	private ResourceLiveFeedService resourceLiveFeedService;
	@Autowired
	private SensorLiveFeedService sensorLiveFeedService;
	@Autowired
	private SensorService sensorService; 

	private int deviceId;
	private String feedDateTimeString;
	private String dateTimePattern;
	private SimpleDateFormat simpleDateFormat;
	private Date feedDateTime;
	private Device device;
	private double sensorValue;

	@Before
	public void setup() {
		parseEventData();
	}

	private void parseEventData() {
		// Received Temp Sensor data
		// deviceId, speed, heading, zone, high temp(90-100), x_coord, y_coord
		// 1, 100, 209, 'dokki', 95, 02-10-2014 11:00 am, 13.2342, 23.343
		deviceId = 1;
		feedDateTimeString = "02-10-2014 11:00 am";
		dateTimePattern = "dd-MM-yyyy hh:mm aa";
		simpleDateFormat = new SimpleDateFormat(dateTimePattern);
		simpleDateFormat.setLenient(false);
		try {
			feedDateTime = simpleDateFormat.parse(feedDateTimeString);
		} catch (ParseException exception) {
			LOG.error("Device feed dateTime  is not parsable: " + feedDateTimeString + ", current system DateTime will be used instead.");
			feedDateTime = new Date();
		}
		sensorValue = 95;
	}

	/**
	 * Main senario is that received data should be inserted in ResourceLiveFeed regardless if it has sensors or alerts.
	 */
	@Test
	public void testDeviceLifeFeedSenario() {

		// first check if device exist.
		device = deviceService.find(deviceId);
		if (device == null) {
			LOG.warn("Device Entity with ID: " + deviceId + " does not exist. Event will be discarded.");
			throw new EntityNotFoundException("Device Entity with ID: " + deviceId + " does not exist.");
		}

		LOG.info(device.toString());

		// check if device is retired.
		if (device.isRetired()) {
			LOG.info("Device is retired. Event will be discarded.");
			return;
		}

		// insert event data into resourceLiveFeed
		ResourceLiveFeed resourceLiveFeed = new ResourceLiveFeed(device, feedDateTime, 13.2342, 23.343, 100, 209, "dokki");
		resourceLiveFeedService.create(resourceLiveFeed);
	}

	/*
	 * Check sensors assigned to the device type
	 */
	@Test
	public void testSensorSenario() {
		device = deviceService.find(deviceId);
		List<Sensor> sensors = device.getDeviceType().getSensors();
		// Map<Sensor, ExecludedSensor> execludedSensors = device.getResource().getExecludedSensors();

		// check if device type has no sensors
		if (sensors == null || sensors.isEmpty()) {
			LOG.info("Device has no sensors. Event cycle will end here.");
			return;
		}

		for (Sensor sensor : sensors) {
			LOG.trace(sensor.toString());

			// check if sensor is retired
			if (sensor.isRetired()) {
				LOG.trace("Sensor is retired, it will be discarded.");
				continue;
			}

			// check if sensor has no configuration
			if (sensor.getSensorConfigurations() == null || sensor.getSensorConfigurations().isEmpty()) {
				LOG.warn("Sensor has no configurations, it will be discarded.");
				continue;
			}

			/*
			 * // check if sensor is excluded from the resource using that device if (execludedSensors != null &&
			 * !execludedSensors.isEmpty()) { if (execludedSensors.containsKey(sensor)) {
			 * LOG.trace("Sensor is execluded, it will be discarded."); continue; } }
			 */

			// check if sensor's configuration is retired
			for (SensorConfiguration sensorConfiguration : sensor.getSensorConfigurations()) {
				LOG.trace(sensorConfiguration.toString());
				if (sensorConfiguration.isRetired()) {
					LOG.trace("Sensor Configuration is retired, it will be discarded");
					continue;
				}

				// Sensor Configuration is on,then insert into SensorLiveFeed
				SensorLiveFeed sensorLiveFeed = new SensorLiveFeed(device, sensorConfiguration, String.valueOf(sensorValue), feedDateTime);
				sensorLiveFeedService.create(sensorLiveFeed);

				// Check if an alert is set on that sensor
			}
		}
	}

	/*
	 * Check alerts set on the device type
	 */
	@Test
	public void testAlertSenario() {
		device = deviceService.find(deviceId);
		List<Alert> alerts = device.getDeviceType().getAlerts();
		// Map<Alert, ExecludedAlert> execludedAlerts = device.getResource().getExecludedAlerts();

		// check if device has no alerts
		if (alerts == null || alerts.isEmpty()) {
			LOG.trace("Device has no alerts.");
			return;
		}

		for (Alert alert : alerts) {
			LOG.trace(alert.toString());

			// check if alert is retired
			if (alert.isRetired()) {
				LOG.trace("Alert is retired, it will be discarded.");
				continue;
			}

			// check if alert has no configuration
			if (alert.getAlertConfigurations() == null || alert.getAlertConfigurations().isEmpty()) {
				LOG.warn("Alert has no configurations, it will be discarded.");
				continue;
			}
			/*
			 * // check if alert is excluded on the resource using that device if (execludedAlerts != null &&
			 * !execludedAlerts.isEmpty()) { if (execludedAlerts.containsKey(alert)) {
			 * LOG.trace("Alert is execluded, it will be discarded."); continue; } }
			 */

			// check if alert configuration is retired
			for (AlertConfiguration alertConfiguration : alert.getAlertConfigurations()) {
				LOG.trace(alertConfiguration.toString());
				if (alertConfiguration.isRetired()) {
					LOG.trace("Alert Configuration is retired, it will be discarded");
					continue;
				}

				// alert configuration is on, construct a map with valid alerts configurations
				// it will be used after finding a Sensor Configuration on(not retired)
				// alertConfigurations.put(alertConfiguration.get, value)
			}

		}

	}
	
}
