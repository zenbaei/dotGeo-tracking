package com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.dao;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

public class SensorConfigurationDAOTest extends DeviceDAOTest {

	@Test
	public void testGetSensorConfigurations() {
		List<SensorConfiguration> tempSensorConfigurations = device.getDeviceType()
				.getSensors().get(1).getSensorConfigurations();
		List<SensorConfiguration> oilSensorConfigurations = device.getDeviceType()
				.getSensors().get(0).getSensorConfigurations();
		assertEquals(90.0, tempSensorConfigurations.get(1).getMaxValue());
		assertEquals("In", oilSensorConfigurations.get(0).getTextValue());
	}
	
}
