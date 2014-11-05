package com.esrinea.dotGeo.tracking.service.facade.business;

import org.apache.log4j.Logger;

public class TrackingServiceFacadeKarafTest {

	private TrackingServiceFacade trackingServiceFacade;
	private Logger log = Logger.getLogger(getClass());

	public void setTrackingServiceFacade(TrackingServiceFacade trackingServiceFacade) {
		this.trackingServiceFacade = trackingServiceFacade;
	}

	public void test() {
		if (trackingServiceFacade != null)
			log.info("TrackingServiceFacade Service has been initialized successfully.");
		else
			log.error("TrackingServiceFacade Service initialization failed.");
	}
}
