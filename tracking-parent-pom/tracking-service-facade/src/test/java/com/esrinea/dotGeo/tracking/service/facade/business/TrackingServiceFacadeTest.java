package com.esrinea.dotGeo.tracking.service.facade.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.service.component.alert.AlertService;
import com.esrinea.dotGeo.tracking.service.component.alertConfiguration.AlertConfigurationService;
import com.esrinea.dotGeo.tracking.service.component.alertLiveFeed.AlertLiveFeedService;
import com.esrinea.dotGeo.tracking.service.component.sensor.SensorService;
import com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed.SensorLiveFeedService;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-service-spring-test-context.xml", "classpath:/spring/tracking-model-spring-test-context.xml", "classpath:/spring/tracking-service-facade-spring-test-context.xml" })
@Transactional(propagation = Propagation.REQUIRED)
public class TrackingServiceFacadeTest {

	@Autowired
	private TrackingServiceFacade trackingServiceFacade;
	@Autowired
	private SensorService sensorService;
	@Autowired
	private SensorLiveFeedService sensorLiveFeedService;
	@Autowired
	private AlertConfigurationService alertConfigurationService;
	@Autowired
	private AlertLiveFeedService alertLiveFeedService;
	@Autowired
	private AlertService alertService;


	@Before
	public void init() {
		trackingServiceFacade.initializeCache();
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	@Rollback(value = true)
	public void testDeviceFeedReceived() throws Exception {
		for (EventData eventData : EventData.createWithDummyData("C:/devices.txt")) {
			trackingServiceFacade.deviceFeedReceived(eventData); // Check if sensorConfigurations inserted right in sensorLiveFeed
		}
		/*
		 * // find sensorLiveFeed by sensor value SensorLiveFeed oilSensorLiveFeed = sensorLiveFeedService.find("in"); Assert.assertNotNull(oilSensorLiveFeed); Assert.assertEquals("OIL", oilSensorLiveFeed.getSensorConfiguration().getSensor().getNameEn());
		 * 
		 * // find sensorLiveFeed by sensor value SensorLiveFeed tempSensorLiveFeed = sensorLiveFeedService.find("50"); Assert.assertNotNull(tempSensorLiveFeed); Assert.assertEquals("in", oilSensorLiveFeed.getSensorConfiguration().getTextValue().toLowerCase()); Assert.assertEquals("TEMP",
		 * tempSensorLiveFeed.getSensorConfiguration().getSensor().getNameEn());
		 * 
		 * // Check if alertConfigurations inserted right in alertLiveFeed Alert compoundAlert = alertService.find(4); AlertLiveFeed alertLiveFeed = alertLiveFeedService.findByAlert(compoundAlert.getId()); Assert.assertNotNull(alertLiveFeed);
		 * 
		 * // Check if alertConfigurations inserted right in alertLiveFeed Alert compoundAlert2 = alertService.find(5); try { AlertLiveFeed alertLiveFeed2 = alertLiveFeedService.findByAlert(compoundAlert2.getId()); Assert.fail("the alert should not exist"); } catch (NoResultException ex) { }
		 */
	}
}
