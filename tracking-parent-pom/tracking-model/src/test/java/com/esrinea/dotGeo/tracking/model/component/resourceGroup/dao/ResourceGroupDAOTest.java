package com.esrinea.dotGeo.tracking.model.component.resourceGroup.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-spring-test-context.xml" })
public class ResourceGroupDAOTest{
	
	@Autowired
	private ResourceGroupDAO resourceGroupDAO; 
	
	@Test
	public void testFindByDeviceSerialRetired(){
		List<ResourceGroup> resourceGroups = resourceGroupDAO.find("2", false);
		Assert.assertFalse(resourceGroups.isEmpty());
	}
	
	@Test
	public void testFindByResource(){
		List<ResourceGroup> resourceGroups = resourceGroupDAO.find(7, false);
		Assert.assertFalse(resourceGroups.isEmpty());
	}
	

}
