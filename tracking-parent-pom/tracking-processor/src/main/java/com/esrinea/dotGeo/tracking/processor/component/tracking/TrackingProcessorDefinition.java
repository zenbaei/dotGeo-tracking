package com.esrinea.dotGeo.tracking.processor.component.tracking;

import com.esri.ges.processor.GeoEventProcessorDefinitionBase;

public class TrackingProcessorDefinition extends GeoEventProcessorDefinitionBase {
	
	public TrackingProcessorDefinition() {
	}
	
	@Override
	public String getName() {
		return "TrackingProcessor";
	}

	@Override
	public String getDomain() {
		return "tracking.processor";
	}

	@Override
	public String getVersion() {
		return "10.2.2";
	}

	@Override
	public String getLabel() {
		return "Tracking Processor";
	}

	@Override
	public String getDescription() {
		return "Dot Geo Tracking Processor.";
	}

	@Override
	public String getContactInfo() {
		return "zenbaei@gmail.com";
	}
}