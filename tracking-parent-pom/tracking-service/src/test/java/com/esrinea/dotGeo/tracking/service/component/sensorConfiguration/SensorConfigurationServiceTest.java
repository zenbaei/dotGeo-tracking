package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;
import com.esrinea.dotGeo.tracking.service.component.sensorConfiguration.SensorConfigurationService;

public class SensorConfigurationServiceTest extends DeviceServiceTest {

	@Autowired
	private SensorConfigurationService sensorConfigurationService;

	@Test
	public void testIsBusinessRuleSatisfiedWhenString() {
		// OIL Sensor has 2 configurations, first with textValue=In and second
		// with textValue=Out
		List<SensorConfiguration> sensorConfigurations = deviceService.find(1)
				.getDeviceType().getSensors().get(0).getSensorConfigurations();

		sensorConfigurationService.isBusinessRuleSatisfied(
				sensorConfigurations.get(0), "in");

	}

}
