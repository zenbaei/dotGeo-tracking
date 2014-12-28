package com.esrinea.dotGeo.tracking.service.facade.dataMapper;

import java.util.Map;

import org.apache.log4j.Logger;

import com.esri.ges.core.geoevent.GeoEvent;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

/**
 * It implements {@link GeoEventDataExtractor#extract(GeoEvent)} as a template method.
 * 
 * @author islam.zenbaei
 *
 */

public abstract class AbstractGeoEventDataExtractorTemplate implements GeoEventDataExtractor {

	private static Logger LOG = Logger.getLogger(AbstractGeoEventDataExtractorTemplate.class);
	protected final String ERROR_MSG = "Unable to extract data from field name %s, please make sure it is not null and is defined with the right data type in GeoEvent Data Definition.";
	protected final String VALUE_MSG = "\n%s value= %s";

	// TODO: ignore main fields case for instance; if xCoord wasn't created in same case in the DataDefinition then it won't be retrieved!
	@Override
	public EventData extract(GeoEvent geoEvent) throws Exception {
		LOG.debug("\n----------------------------------------------------------------------------------------------------------------------------------------------------\nGeoEvent Data Received, Data extraction will happened based on the fields' name and type defined in the GeoEvent Data Definition:\n----------------------------------------------------------------------------------------------------------------------------------------------------"
				.toUpperCase());

		String serial = null;
		double xCoord = 0;
		double yCoord = 0;
		int speed = 0;
		double heading = 0;

		// get values from GeoEvent based on the data definition of the fields
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

		// initialize EventData with the received values
		EventData eventData = new EventData(serial, xCoord, yCoord, speed, heading);

		eventData.setSensorValues(getSensors(geoEvent));

		LOG.debug(String.format("Event Data after extraction: %s ", eventData));
		return eventData;
	}

	protected abstract Map<String, Object> getSensors(GeoEvent geoEvent);

}
