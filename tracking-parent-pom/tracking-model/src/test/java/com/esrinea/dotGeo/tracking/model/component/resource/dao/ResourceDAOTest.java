package com.esrinea.dotGeo.tracking.model.component.resource.dao;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;

	
public class ResourceDAOTest extends DeviceDAOTest {
	
	
	@Test
	public void testGetExecludedSensors(){
		List<ExecludedSensor> execludedSensors = device.getResource().getExecludedSensors();
		assertEquals("HEAT", execludedSensors.get(0).getSensor().getNameEn()); 
	}
	
	
}
