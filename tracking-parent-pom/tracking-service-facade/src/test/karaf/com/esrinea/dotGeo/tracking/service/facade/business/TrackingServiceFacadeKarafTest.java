package com.esrinea.dotGeo.tracking.service.facade.business;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

public class TrackingServiceFacadeKarafTest {

	private TrackingServiceFacade trackingServiceFacade;
	private Logger log = Logger.getLogger(getClass());

	public void setTrackingServiceFacade(TrackingServiceFacade trackingServiceFacade) {
		this.trackingServiceFacade = trackingServiceFacade;
	}

	public void test() {
		if (trackingServiceFacade != null) {
			log.info("TrackingServiceFacade Service has been initialized successfully.");
			log.info("Calling trackingServiceFacade.initCache.");
			try {
				trackingServiceFacade.deviceFeedReceived(EventData.createWithDummyData());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			log.error("TrackingServiceFacade Service initialization failed.");
	}

}
