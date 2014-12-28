package com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity.AlertSensorLiveFeed;
import com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity.AlertSensorLiveFeedId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-spring-test-context.xml" })
@Transactional
public class AlertSensorLiveFeedDAOTest  {

	
	@Autowired
	private AlertSensorLiveFeedDAO alertSensorLiveFeedDAO;
	
	@Test
	public void testCreateAlertSensorLiveFeed() throws Exception{
		AlertSensorLiveFeedId alertSensorLiveFeedId = new AlertSensorLiveFeedId(1, 1);
		AlertSensorLiveFeed alertSensorLiveFeed = new AlertSensorLiveFeed(alertSensorLiveFeedId);
		alertSensorLiveFeedDAO.create(alertSensorLiveFeed);
		
	}
}
