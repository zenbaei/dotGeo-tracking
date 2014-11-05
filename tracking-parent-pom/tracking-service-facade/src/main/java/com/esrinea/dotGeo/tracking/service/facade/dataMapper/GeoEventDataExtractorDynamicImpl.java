package com.esrinea.dotGeo.tracking.service.facade.dataMapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.esri.ges.core.geoevent.FieldDefinition;
import com.esri.ges.core.geoevent.GeoEvent;

/**
 * This implementation allows to send dynamic number of sensors, any GeoEvent DataDefinition other than serial, heading, speed, xcoord and ycoord will be treated as a sensor, and same name defined for that field in the DataDefinition will be used to map its SensorConfiguration from the DB, thus
 * sensor names should be identical between DataDefinition and DB.<br>
 * Note: that it's not a fully dynamic, the part concerning getting serial, heading... values are statically written in code.
 * 
 * @author islam.zenbaei
 *
 */
public class GeoEventDataExtractorDynamicImpl extends AbstractGeoEventDataExtractorTemplate implements GeoEventDataExtractor {
	private static Logger LOG = Logger.getLogger(GeoEventDataExtractorDynamicImpl.class);

	@Override
	protected Map<String, Object> getSensors(GeoEvent geoEvent) {
		Map<String, Object> sensorValues = new HashMap<String, Object>();

		for (FieldDefinition fieldDefinition : geoEvent.getGeoEventDefinition().getFieldDefinitions()) {
			String fieldName = fieldDefinition.getName();
			Object fieldValue = geoEvent.getField(fieldDefinition.getName());
			// any field name other the main ones (serial, heading,...) will be treated as a sensor field
			if (!fieldName.equalsIgnoreCase("serial") && !fieldName.equalsIgnoreCase("heading") && !fieldName.equalsIgnoreCase("speed") && !fieldName.equalsIgnoreCase("xcoord") && !fieldName.equalsIgnoreCase("ycoord")) {
				if (fieldValue != null) {
					sensorValues.put(fieldName, fieldValue);
					LOG.debug(String.format(VALUE_MSG, fieldName, fieldValue));
				} else {
					LOG.debug(String.format("No field value for sensor with name %s exist in the received data definition.", fieldName));
				}
			}
		}

		return sensorValues;

	}
}
