package com.esrinea.dotGeo.tracking.service.component.sensor;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;

public class SensorServiceTest extends DeviceServiceTest {

	@Autowired
	private SensorService sensorService;

	@Test
	public void testFindNonRetiredSensors() {
		Device device = deviceService.find(1, false);
		List<Sensor> sensors = sensorService.find(device.getDeviceType().getId(), false);
		assertNotNull(sensors);
		assertFalse(sensors.isEmpty());
		for (Sensor sensor : sensors) {
			assertFalse(sensor.isRetired());
		}
		assertEquals(2, sensors.size());
	}
}
