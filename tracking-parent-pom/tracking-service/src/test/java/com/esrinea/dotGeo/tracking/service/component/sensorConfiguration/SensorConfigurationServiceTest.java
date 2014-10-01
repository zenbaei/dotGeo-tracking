package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;
import com.esrinea.dotGeo.tracking.service.component.sensorConfiguration.SensorConfigurationService;

public class SensorConfigurationServiceTest extends DeviceServiceTest {

	@Autowired
	private SensorConfigurationService sensorConfigurationService;
	private List<SensorConfiguration> sensorConfigurations;

	@Test
	public void testIsBusinessRuleSatisfiedWhenString() {
		// OIL Sensor(first sensor under device 1 and deviceType 1) has 2
		// configurations,
		// first with textValue=In
		// second with textValue=Out
		this.sensorConfigurations = deviceService.find(1).getDeviceType()
				.getSensors().get(0).getSensorConfigurations();
		
		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(0), "in"));

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(1), "ouT"));

	}

	@Test
	public void testIsBusinessRuleSatisfiedWhenDouble() {
		// TEMP Sensor(second sensor under device 1 and deviceType 1) has 3
		// configurations,
		// first with minValue=25, maxValue=43 and configText = low
		// second with minValue=43, maxValue=90 and configText = med
		// third with minValue=90, maxValue=100 and configText = high
		this.sensorConfigurations = deviceService.find(1).getDeviceType()
				.getSensors().get(1).getSensorConfigurations();
		
		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(0), 30.0));

		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(1), 50.0));
		
		assertTrue(sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(2), 95.0));
		
		assertFalse(sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(2), 120.0));

	}

}
