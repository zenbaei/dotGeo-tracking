package com.esrinea.dotGeo.tracking.processor.component.tracking;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.processor.GeoEventProcessor;
import com.esri.ges.processor.GeoEventProcessorServiceBase;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;
import com.esrinea.dotGeo.tracking.service.facade.TrackingServiceFacade;

public class TrackingProcessorService extends GeoEventProcessorServiceBase {
	
	private TrackingServiceFacade trackingServiceFacade;

	public TrackingProcessorService() {
		definition = new TrackingProcessorDefinition();
	}

	@Override
	public GeoEventProcessor create() throws ComponentException {
		return new TrackingProcessor(definition, trackingServiceFacade);
	}
	
	public void setTrackingServiceFacade(TrackingServiceFacade trackingServiceFacade) {
		this.trackingServiceFacade = trackingServiceFacade;
	}
}