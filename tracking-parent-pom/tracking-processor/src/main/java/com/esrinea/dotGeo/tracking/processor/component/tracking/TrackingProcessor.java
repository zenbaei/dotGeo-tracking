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
		int deviceId = 0;
		double xCoord = 0;
		double yCoord = 0;
		int speed = 0;
		Object tempSensor = null;
		Object oilSenosr = null;

		try {
			deviceId = (Integer) geoEvent.getField("id");
			xCoord = (Double) geoEvent.getField("xCoord");
			yCoord = (Double) geoEvent.getField("yCoord");
			speed = (Integer) geoEvent.getField("speed");
			tempSensor = geoEvent.getField("TEMP");
			oilSenosr = geoEvent.getField("OIL");
		} catch (Exception ex) {
			LOG.error("Unable to extract fields from received tracking geo event data, make sure the Geo Data Definition corresponds to the right field names along with their data types definied in our custom EventData object.");
		}

		EventData eventData = new EventData(deviceId, xCoord, yCoord, speed);
		eventData.addSensorValue("TEMP", tempSensor);
		eventData.addSensorValue("OIL", oilSenosr);

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