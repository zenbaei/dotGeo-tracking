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
		String serial = null;
		double xCoord = 0;
		double yCoord = 0;
		int speed = 0;
		double heading = 0;
		Object speedSensor = null;
		Object seatBelt = null;
		// Object tempSensor = null;
		// Object oilSenosr = null;

		try {
			// get values from GeoEvent based on the data definition of the fields
			serial = (String) geoEvent.getField("serial");
			xCoord = (Double) geoEvent.getField("xCoord");
			yCoord = (Double) geoEvent.getField("yCoord");
			speed = (Integer) geoEvent.getField("speed");
			heading = (Double) geoEvent.getField("heading");
			try {
				speedSensor = geoEvent.getField("speedSensor");
			} catch (Exception ex) {
				LOG.debug("No field with name speedSensor exist in the received data definition.");
			}
			try {
				seatBelt = geoEvent.getField("seatBelt");
			} catch (Exception ex) {
				LOG.debug("No field with name seatBelt exist in the received data definition.");
			}
			// tempSensor = geoEvent.getField("TEMP");
			// oilSenosr = geoEvent.getField("OIL");
		} catch (Exception ex) {
			LOG.error("Unable to extract fields from received tracking geo event data, make sure the Geo Data Definition corresponds to the right field names along with their data types definied in our custom EventData object,Also make sure that none of the received values is null.");
			throw ex;
		}
		// initialize EventData with the received values
		EventData eventData = new EventData(serial, xCoord, yCoord, speed, heading);

		if (speedSensor != null) {
			eventData.addSensorValue("SPEED", speedSensor);
		}
		if (seatBelt != null) {
			eventData.addSensorValue("SEAT BELT", seatBelt);
		}

		// eventData.addSensorValue("TEMP", tempSensor);
		// eventData.addSensorValue("OIL", oilSenosr);

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