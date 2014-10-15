package com.esrinea.dotGeo.tracking.service.component.device;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.persistence.NoResultException;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/application-context.xml",
		"classpath:/spring/tracking-service-spring-test-context.xml", "classpath:/spring/tracking-model-spring-test-context.xml" })
public class DeviceServiceTest {

	@Autowired
	protected DeviceService deviceService;

	@Test
	public void testGetDeviceService() {
		Assert.assertNotNull(deviceService);
	}

	@Test
	public void testFindNonRetiredDevice() {
		Device device = deviceService.find(1, false);
		assertNotNull(device);
		assertFalse(device.isRetired());
	}

	@Test
	public void testFindRetiredDevice() {
		Device device = null;
		try {
			device = deviceService.find(1, true);
		} catch (NoResultException ex) {
		}
		if (device != null && !device.isRetired()) {
			fail("Device should have status of retired.");
		}
	}
}
