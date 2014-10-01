package com.esrinea.dotGeo.tracking.service.common;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/*",
		"classpath:/spring/tracking-service-test-context.xml",
		"classpath:/spring/tracking-model-test-context.xml" })
public class SpringContextTest {

	@Test
	public void testGetSpringApplicationContext() {
		ApplicationContext ctx = SpringContext.getApplicationContext();

		DeviceService deviceService = (DeviceService) ctx
				.getBean("deviceService");

		assertNotNull(deviceService);

	}

}
