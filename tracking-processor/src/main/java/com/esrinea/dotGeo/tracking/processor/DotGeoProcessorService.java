package com.esrinea.dotGeo.tracking.processor;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.processor.GeoEventProcessor;
import com.esri.ges.processor.GeoEventProcessorServiceBase;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;

public class DotGeoProcessorService extends GeoEventProcessorServiceBase {
	private DeviceService deviceService;

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public DotGeoProcessorService() {
		definition = new DotGeoProcessorDefinition();
	}

	@Override
	public GeoEventProcessor create() throws ComponentException {
		return new DotGeoProcessor(definition, deviceService);
	}
}