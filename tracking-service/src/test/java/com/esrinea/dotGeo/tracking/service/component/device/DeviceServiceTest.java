package com.esrinea.dotGeo.tracking.service.component.device;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/application-context.xml",
		"classpath:/spring/tracking-service-test-context.xml" })
public class DeviceServiceTest {

	@Autowired
	protected DeviceService deviceService;

	@Test
	public void testGetEmployee() {
		Assert.assertNotNull(deviceService);
	}

}
