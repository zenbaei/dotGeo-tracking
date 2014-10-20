package com.esrinea.dotGeo.tracking.processor.component.tracking;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.core.geoevent.GeoEvent;
import com.esri.ges.core.property.Property;
import com.esri.ges.processor.GeoEventProcessorBase;
import com.esri.ges.processor.GeoEventProcessorDefinition;
import com.esrinea.dotGeo.tracking.service.common.dto.EventData;
import com.esrinea.dotGeo.tracking.service.facade.TrackingServiceFacade;

public class TrackingProcessor extends GeoEventProcessorBase {
	private static final Log LOG = LogFactory.getLog(TrackingProcessor.class);
	private TrackingServiceFacade trackingServiceFacade;

	protected TrackingProcessor(GeoEventProcessorDefinition definition, TrackingServiceFacade trackingServiceFacade) throws ComponentException {
		super(definition);
		this.trackingServiceFacade = trackingServiceFacade;
		trackingServiceFacade.buildDeviceType();
	}

	@Override
	public GeoEvent process(GeoEvent geoEvent) throws Exception {

		LOG.trace("Geo Event Device ID: " + geoEvent.getTrackId());
		LOG.trace("Geo Event x cord: " + geoEvent.getField("x_cord"));
		

		EventData eventData = new EventData((Integer) geoEvent.getField("id"), (Double) geoEvent.getField("xCoord"), (Double) geoEvent.getField("yCoord"), (Integer) geoEvent.getField("speed"), (Double) geoEvent.getField("heading"));

		eventData.addSensorValue("TEMP", geoEvent.getField("TEMP"));
		eventData.addSensorValue("OIL", geoEvent.getField("OIL"));

		trackingServiceFacade.deviceFeedReceived(eventData);
		
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