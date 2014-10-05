package com.esrinea.dotGeo.tracking.model.component.resource.dao;

import static junit.framework.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

public class ResourceDAOTest extends DeviceDAOTest {

	@Test
	public void testGetExecludedSensors() {
		Sensor heatSenosr = device.getDeviceType().getSensors().get(2);
		Map<Sensor, ExecludedSensor> execludedSensors = device.getResource()
				.getExecludedSensors();
		assertEquals("HEAT", execludedSensors.get(heatSenosr).getSensor()
				.getNameEn());
	}

}
