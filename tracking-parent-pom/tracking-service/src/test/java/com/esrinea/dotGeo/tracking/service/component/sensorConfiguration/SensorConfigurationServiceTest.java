package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;
import com.esrinea.dotGeo.tracking.service.component.sensor.SensorService;

public class SensorConfigurationServiceTest extends DeviceServiceTest {

	@Autowired
	private SensorConfigurationService sensorConfigurationService;

	@Autowired
	private SensorService sensorService;

	@Test
	public void testIsBusinessRuleSatisfiedWhenString() {
		// OIL Sensor(first sensor under device 1 and deviceType 1) has 2
		// configurations,
		// first with textValue=In
		// second with textValue=Out

		List<Sensor> sensors = sensorService.find(deviceService.find(1).getDeviceType().getId(), false);
		List<SensorConfiguration> sensorConfigurations = sensorConfigurationService.find(sensors.get(0).getId(), false);

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(sensorConfigurations.get(0), "in"));

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(sensorConfigurations.get(1), "ouT"));

	}

	@Test
	public void testIsBusinessRuleSatisfiedWhenDouble() {
		// TEMP Sensor(second sensor under device 1 and deviceType 1) has 3
		// configurations,
		// first with minValue=25, maxValue=43 and configText = low
		// second with minValue=43, maxValue=90 and configText = med
		// third with minValue=90, maxValue=100 and configText = high

		List<Sensor> sensors = sensorService.find(deviceService.find(1).getDeviceType().getId(), false);

		List<SensorConfiguration> sensorConfigurations = sensorConfigurationService.find(sensors.get(1).getId(), false);

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(sensorConfigurations.get(0), 30.0));

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(sensorConfigurations.get(1), 50.0));

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(sensorConfigurations.get(2), 95.0));

		assertFalse(sensorConfigurationService.isBusinessRuleSatisfied(sensorConfigurations.get(2), 120.0));

	}

	@Test
	public void testFindNonRetiredSensorConfigurations() {
		Device device = deviceService.find(1, false);
		List<Sensor> sensors = sensorService.find(device.getDeviceType().getId(), false);
		assertNotNull(sensors);
		for (Sensor sensor : sensors) {
			List<SensorConfiguration> sensorConfigurations = sensorConfigurationService.find(sensor.getId(), false);

			if (sensor.getId() == 1)
				assertNotNull(sensorConfigurations);

			for (SensorConfiguration sensorConfiguration : sensorConfigurations) {
				assertFalse(sensorConfiguration.isRetired());
			}
		}
	}

}
