package com.esrinea.dotGeo.tracking.model.component.deviceType.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-spring-test-context.xml" })
@Transactional
public class DeviceTypeDAOTest {

	@Autowired
	private DeviceTypeDAO deviceTypeDAO;

	@Test
	public void testFindNonRetired() {
		List<DeviceType> deviceTypes = deviceTypeDAO.find(false);
		Assert.assertNotNull(deviceTypes);
		Assert.assertFalse(deviceTypes.isEmpty());
	}

	@Test
	public void testFindRetired() {
		List<DeviceType> deviceTypes = deviceTypeDAO.find(true);
		Assert.assertNotNull(deviceTypes);
		Assert.assertTrue(deviceTypes.isEmpty());
	}
	

}
