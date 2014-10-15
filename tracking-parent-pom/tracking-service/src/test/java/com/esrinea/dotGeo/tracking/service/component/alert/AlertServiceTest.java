package com.esrinea.dotGeo.tracking.service.component.alert;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;

public class AlertServiceTest extends DeviceServiceTest {
	
	@Autowired
	private AlertService alertService;
	
	
	@Test
	public void testFindNonRetiredAlerts(){
		Device device = deviceService.find(1, false);
		List<Alert> alerts = alertService.find(device.getDeviceType().getId(), false);
		Assert.assertNotNull(alerts);
		Assert.assertFalse(alerts.isEmpty());
	}

}
