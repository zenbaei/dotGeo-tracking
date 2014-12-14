package com.esrinea.dotGeo.tracking.service.component.deviceType;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/application-context.xml", "classpath:/spring/tracking-service-spring-test-context.xml", "classpath:/spring/tracking-model-spring-test-context.xml" })
public class DeviceTypeServiceTest {

	@Autowired
	private DeviceTypeService deviceTypeService;

	@Test
	public void testFindByRetired() {
		List<DeviceType> deviceTypes = deviceTypeService.find(false);
		Assert.assertNotNull(deviceTypes);
		Assert.assertFalse(deviceTypes.isEmpty());
	}

}
