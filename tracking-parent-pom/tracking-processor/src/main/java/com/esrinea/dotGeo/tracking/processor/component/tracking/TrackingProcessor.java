package com.esrinea.dotGeo.tracking.processor.component.tracking;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.core.geoevent.GeoEvent;
import com.esri.ges.core.property.Property;
import com.esri.ges.processor.GeoEventProcessorBase;
import com.esri.ges.processor.GeoEventProcessorDefinition;
import com.esrinea.dotGeo.tracking.service.facade.business.TrackingServiceFacade;

public class TrackingProcessor extends GeoEventProcessorBase {
	private static final Log LOG = LogFactory.getLog(TrackingProcessor.class);
	private TrackingServiceFacade trackingServiceFacade;

	protected TrackingProcessor(GeoEventProcessorDefinition definition, TrackingServiceFacade trackingServiceFacade) throws ComponentException {
		super(definition);
		this.trackingServiceFacade = trackingServiceFacade;
	}

	@Override
	public GeoEvent process(GeoEvent geoEvent) throws Exception {
		LOG.debug("\n--------------------------------------------------------------------------------------------------------------------\nGEO EVENT DATA RECEIVED\n--------------------------------------------------------------------------------------------------------------------");
		trackingServiceFacade.deviceFeedReceived(geoEvent);
		return geoEvent;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(definition.getName());
		sb.append("/");
		sb.append(definition.getVersion());
		sb.append("[");
		for (Property p : getProperties()) {
			sb.append(p.getDefinition().getPropertyName());
			sb.append(":");
			sb.append(p.getValue());
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

}