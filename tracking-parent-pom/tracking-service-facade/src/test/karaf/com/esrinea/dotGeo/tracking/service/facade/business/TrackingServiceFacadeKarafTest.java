package com.esrinea.dotGeo.tracking.service.facade.business;

import org.apache.log4j.Logger;

public class TrackingServiceFacadeKarafTest {

	private TrackingServiceFacade trackingServiceFacade;
	private Logger log = Logger.getLogger(getClass());

	public void setTrackingServiceFacade(TrackingServiceFacade trackingServiceFacade) {
		this.trackingServiceFacade = trackingServiceFacade;
	}

	public void test() throws Exception {
		if (trackingServiceFacade != null) {
			log.info("TrackingServiceFacade Service has been initialized successfully.");
			log.info("Calling trackingServiceFacade.initCache.");
			try {
				// trackingServiceFacade.deviceFeedReceived(EventData.createWithDummyData());
				if (trackingServiceFacade == null)
					throw new IllegalStateException("Unable to initialize TrackingServiceFacade.");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			log.error("TrackingServiceFacade Service initialization failed.");
	}

}
