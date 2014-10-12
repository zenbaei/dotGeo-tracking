package com.esrinea.dotGeo.tracking.service.component.device;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/application-context.xml",
		"classpath:/spring/tracking-service-test-context.xml",
		"classpath:/spring/tracking-model-test-context.xml" })
public class DeviceServiceTest {

	@Autowired
	protected DeviceService deviceService;

	@Test
	public void testGetDeviceService() {
		Assert.assertNotNull(deviceService);
	}

}
