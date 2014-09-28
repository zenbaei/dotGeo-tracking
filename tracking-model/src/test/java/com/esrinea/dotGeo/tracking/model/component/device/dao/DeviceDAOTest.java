package com.esrinea.dotGeo.tracking.model.component.device.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-test-context.xml" })
@Transactional
public class DeviceDAOTest {

	@Autowired
	private DeviceDAO<Device> deviceDAO;

	@Test
	public void testFindById() {
		Device device = deviceDAO.find(1);
		Assert.assertEquals(1, device.getId());
	}

}
