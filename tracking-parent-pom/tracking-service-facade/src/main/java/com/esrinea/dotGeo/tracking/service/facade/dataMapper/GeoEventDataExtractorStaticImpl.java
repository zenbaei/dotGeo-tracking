package com.esrinea.dotGeo.tracking.service.facade.dataMapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.esri.ges.core.geoevent.GeoEvent;

/**
 * This implementation expects that the sensors that will be defined in the GeoEvent DataDefinition are known in advance, <br>
 * thus sensors' names are coded statically to find their values from the GeoEvent and map it sensorConfigurations.
 * 
 * @author islam.zenbaei
 *
 */
public class GeoEventDataExtractorStaticImpl extends AbstractGeoEventDataExtractorTemplate implements GeoEventDataExtractor {

	private static Logger LOG = Logger.getLogger(GeoEventDataExtractorStaticImpl.class);

	@Override
	protected Map<String, Object> getSensors(GeoEvent geoEvent) {
		// TODO:inform why you are using sensors' name instead of id (mainly because i'd have to define field name in DataDefiniton with id
		Map<String, Object> sensorValues = new HashMap<String, Object>();
		Object speedSensorValue = null;
		final String SPEED_SENSOR = "speedSensor";
		Object temperatureSensorValue = null;
		String TEMP_SENSOR = "temperatureSensor";
		Object seatBeltSensorValue = null;
		String SEAT_BLET_SENSOR = "seatBeltSensor";

		speedSensorValue = geoEvent.getField(SPEED_SENSOR);
		if (speedSensorValue != null) {
			// use same sensor name as defined in SENSORS' Name_En column in DB
			sensorValues.put("SPEED", speedSensorValue);
			LOG.debug(String.format(VALUE_MSG, SPEED_SENSOR, speedSensorValue));
		} else {
			LOG.debug(String.format("No field value for sensor with name %s exist in the received data definition.", SPEED_SENSOR));
		}

		temperatureSensorValue = geoEvent.getField(TEMP_SENSOR);
		if (temperatureSensorValue != null) {
			// use same sensor name as defined in SENSORS' Name_En column in DB
			sensorValues.put("Temperature", temperatureSensorValue);
			LOG.debug(String.format(VALUE_MSG, TEMP_SENSOR, temperatureSensorValue));
		} else {
			LOG.debug(String.format("No field value for sensor with name %s exist in the received data definition.", TEMP_SENSOR));
		}

		seatBeltSensorValue = geoEvent.getField(SEAT_BLET_SENSOR);
		if (seatBeltSensorValue != null) {
			// use same sensor name as defined in SENSORS' Name_En column in DB
			sensorValues.put("Seat Belt", seatBeltSensorValue);
			LOG.debug(String.format(VALUE_MSG, SEAT_BLET_SENSOR, seatBeltSensorValue));
		} else {
			LOG.debug(String.format("No field value for sensor with name %s exist in the received data definition.", SEAT_BLET_SENSOR));
		}

		return sensorValues;
	}

}
