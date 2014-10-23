package com.esrinea.dotGeo.tracking.service.facade;

import com.esrinea.dotGeo.tracking.service.common.dto.EventData;

public interface TrackingServiceFacade {

	public void buildDeviceType();
	public void deviceFeedReceived(EventData eventData);
}
