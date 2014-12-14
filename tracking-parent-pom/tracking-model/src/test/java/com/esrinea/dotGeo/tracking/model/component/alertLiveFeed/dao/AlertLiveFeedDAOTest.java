package com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.esrinea.dotGeo.tracking.model.component.alert.dao.AlertDAO;
import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.dao.AlertLiveFeedDAO;
import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity.AlertLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;

public class AlertLiveFeedDAOTest extends DeviceDAOTest {

	@Autowired
	private AlertDAO alertDAO;
	@Autowired
	private AlertLiveFeedDAO alertLiveFeedDAO;

	
	@Test
	@Rollback(value=true)
	public void testCreateAlertLiveFeed() {
		Alert alert = alertDAO.find(6);
		AlertLiveFeed alertLiveFeed = new AlertLiveFeed(device, alert, new Date(), "zone", 234.234, 22.343);
		alertLiveFeedDAO.create(alertLiveFeed);
		Assert.assertTrue(alertLiveFeed.getId() != 0);
	}

}
