package com.esrinea.dotGeo.tracking.model.component.deviceType.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

public class DeviceTypeDAOTest extends DeviceDAOTest {
	
	@Autowired
	private DeviceTypeDAO deviceTypeDAO;
	
	@Test
	public void testFindNonRetired(){
		List<DeviceType> deviceTypes = deviceTypeDAO.findAll(false);
		Assert.assertNotNull(deviceTypes);
		Assert.assertFalse(deviceTypes.isEmpty());
	}

	@Test
	public void testFindRetired(){
		List<DeviceType> deviceTypes = deviceTypeDAO.findAll(true);
		Assert.assertNotNull(deviceTypes);
		Assert.assertTrue(deviceTypes.isEmpty());
	}
	
}
