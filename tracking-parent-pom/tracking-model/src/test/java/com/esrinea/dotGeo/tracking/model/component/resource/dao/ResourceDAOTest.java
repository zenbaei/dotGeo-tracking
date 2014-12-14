package com.esrinea.dotGeo.tracking.model.component.resource.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-spring-test-context.xml" })
public class ResourceDAOTest {
	
	@Autowired
	private DeviceDAO deviceDAO;
	
	@Autowired
	private ResourceDAO resourceDAO;

	@Test
	public void testGetExecludedSensors() {
		Device device = deviceDAO.find(20, false);
		Sensor heatSenosr = device.getDeviceType().getSensors().get(2);
		Map<Sensor, ExecludedSensor> execludedSensors = device.getResource()
				.getExecludedSensors();
		assertEquals("HEAT", execludedSensors.get(heatSenosr).getSensor()
				.getNameEn());
	}
	
	@Test
	public void testFindByNonRetired(){
		List<Resource> resources = resourceDAO.find(false);
		assertFalse(resources.isEmpty());
	}
}
