package com.esrinea.dotGeo.tracking.processor.component.tracking;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.processor.GeoEventProcessor;
import com.esri.ges.processor.GeoEventProcessorServiceBase;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;

public class TrackingProcessorService extends GeoEventProcessorServiceBase {
	private DeviceService deviceService;

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public TrackingProcessorService() {
		definition = new TrackingProcessorDefinition();
	}

	@Override
	public GeoEventProcessor create() throws ComponentException {
		return new TrackingProcessor(definition, deviceService);
	}
}