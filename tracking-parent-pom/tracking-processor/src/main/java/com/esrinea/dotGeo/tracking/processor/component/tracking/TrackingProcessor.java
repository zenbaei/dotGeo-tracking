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
		LOG.debug("\n--------------------------------------------------------------------------------------------------------------------\nGEO EVENT DATA RECEIVED\n--------------------------------------------------------------------------------------------------------------------");
		String serial = null;
		double xCoord = 0;
		double yCoord = 0;
		int speed = 0;
		double heading = 0;
		Object speedSensor = null;
		Object seatBelt = null;
		final String ERROR_MSG = "Unable to extract data from field name %s, please make sure it is not null and is defined with the right data type in GeoEvent Data Definition.";
		final String VALUE_MSG = "\n%s value= %s";
		// Object tempSensor = null;
		// Object oilSenosr = null;

		// get values from GeoEvent based on the data definition of the fields
		LOG.debug("\nGeoEvent Data Received, Data extraction will happened based on the fields' name and type defined in the GeoEvent Data Definition:");

		try {
			serial = (String) geoEvent.getField("serial");
			LOG.debug(String.format(VALUE_MSG, "serial", serial));
		} catch (Exception ex) {
			LOG.error(String.format(ERROR_MSG, "serial"));
			throw ex;
		}

		try {
			xCoord = (Double) geoEvent.getField("xCoord");
			LOG.debug(String.format(VALUE_MSG, "xCoord", xCoord));
		} catch (Exception ex) {
			LOG.error(String.format(ERROR_MSG, "xCoord"));
			throw ex;
		}

		try {
			yCoord = (Double) geoEvent.getField("yCoord");
			LOG.debug(String.format(VALUE_MSG, "yCoord", yCoord));
		} catch (Exception ex) {
			LOG.error(String.format(ERROR_MSG, "yCoord"));
			throw ex;
		}

		try {
			speed = (Integer) geoEvent.getField("speed");
			LOG.debug(String.format(VALUE_MSG, "speed", speed));
		} catch (Exception ex) {
			LOG.error(String.format(ERROR_MSG, "speed"));
			throw ex;
		}

		try {
			heading = (Double) geoEvent.getField("heading");
			LOG.debug(String.format(VALUE_MSG, "heading", heading));
		} catch (Exception ex) {
			LOG.error(String.format(ERROR_MSG, "heading"));
			throw ex;
		}

		try {
			speedSensor = geoEvent.getField("speedSensor");
			LOG.debug(String.format(VALUE_MSG, "speedSensor", speedSensor));
		} catch (Exception ex) {
			LOG.debug("No field with name speedSensor exist in the received data definition.");
		}

		/*
		 * try { seatBelt = geoEvent.getField("seatBelt"); LOG.debug(String.format(VALUE_MSG, "seatBelt", seatBelt)); } catch (Exception ex) { LOG.debug("No field with name seatBelt exist in the received data definition."); }
		 */
		// tempSensor = geoEvent.getField("TEMP");
		// oilSenosr = geoEvent.getField("OIL");

		// initialize EventData with the received values
		EventData eventData = new EventData(serial, xCoord, yCoord, speed, heading);

		// add sensor with same name defined in the DB
		if (speedSensor != null) {
			eventData.addSensorValue("SPEED", speedSensor);
		}

		/*
		 * if (seatBelt != null) { eventData.addSensorValue("SEAT BELT", seatBelt); }
		 */

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