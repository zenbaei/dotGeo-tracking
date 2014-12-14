package com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.dao.SensorConfigurationDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;

@Transactional
public class SensorLiveFeedDAOTest extends DeviceDAOTest {

	@Autowired
	private SensorLiveFeedDAO sensorLiveFeedDAO;
	@Autowired
	private SensorConfigurationDAO sensorConfigurationDAO;

	@Rollback(value = true)
	@Test
	public void testCreateSensorLiveFeed() {
		SensorConfiguration sensorConfiguration = sensorConfigurationDAO.find(15);
		SensorLiveFeed sensorLiveFeed = new SensorLiveFeed(device, sensorConfiguration, "50.0", new Date());
		sensorLiveFeedDAO.create(sensorLiveFeed);
		Assert.assertTrue(sensorLiveFeed.getId() != 0);
	}
}
