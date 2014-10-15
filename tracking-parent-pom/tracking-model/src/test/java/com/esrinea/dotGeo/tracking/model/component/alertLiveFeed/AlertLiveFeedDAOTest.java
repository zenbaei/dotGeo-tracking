package com.esrinea.dotGeo.tracking.model.component.alertLiveFeed;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
	public void testCreateAlertLiveFeed() {
		Alert alert = alertDAO.find(1);
		AlertLiveFeed alertLiveFeed = new AlertLiveFeed(device, alert, new Date(), "zone");
		alertLiveFeedDAO.create(alertLiveFeed);
		Assert.assertTrue(alertLiveFeed.getId() != 0);
	}

}
