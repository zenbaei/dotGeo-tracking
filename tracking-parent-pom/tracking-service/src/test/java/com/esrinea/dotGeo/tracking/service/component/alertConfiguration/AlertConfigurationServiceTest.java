package com.esrinea.dotGeo.tracking.service.component.alertConfiguration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.service.component.alert.AlertService;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceServiceTest;

public class AlertConfigurationServiceTest extends DeviceServiceTest {

	@Autowired
	private AlertConfigurationService alertConfigurationService;
	@Autowired
	private AlertService alertService;

	@Test
	public void testFindNonRetiredAlertConfigurations() {
		List<Alert> alerts = alertService.find(1, false);
		Assert.assertNotNull(alerts);

		for (Alert alert : alerts) {
			List<AlertConfiguration> alertConfigurations = alertConfigurationService.find(alert.getId(), false);

			if (alert.getNameEn().equals("Oil Alert")) {
				Assert.assertEquals(2, alertConfigurations.size());
			}
		}
		
		for (Alert alert : alerts) {
			List<AlertConfiguration> alertConfigurations = alertConfigurationService.find(alert.getId(), true);

			if (alert.getNameEn().equals("Temp Alert")) {
				Assert.assertEquals(1, alertConfigurations.size());
			}
		}
	}
	
	
	
}