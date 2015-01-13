package com.esrinea.dotGeo.tracking.service.facade.dto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data received from GeoEvent will be set in that object
 * 
 * @author islam.zenbaei
 *
 */
public class EventData {

	private Date feedDateTime;
	private String serial;
	private double xCoord;
	private double yCoord;
	private int speed;
	private double heading;
	private String zone;
	/**
	 * The key represents the Device Type's sensor name while the value represents the real sensor value received from a certain device the key is added after retrieving data from GeoEvent Data Definition in the processor implementation. It is configured to hold double or String.
	 */
	private Map<String, Object> sensorValues = new HashMap<String, Object>();

	public EventData(String serial, double xCoord, double yCoord, int speed, double heading, Map<String, Object> sensorValues) {
		this.serial = serial;
		this.feedDateTime = new Date();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.speed = speed;
		this.heading = heading;
		this.sensorValues = sensorValues;
	}

	public EventData(String serial, double xCoord, double yCoord, int speed, double heading) {
		this.serial = serial;
		this.feedDateTime = new Date();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.speed = speed;
		this.heading = heading;
	}

	public EventData() {
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Date getFeedDateTime() {
		return feedDateTime;
	}

	public void setFeedDateTime(Date feedDateTime) {
		this.feedDateTime = feedDateTime;
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * The key represents the Device Type's sensor name while the value represents the real sensor value received from a certain device the key is added after retrieving data from GeoEvent Data Definition in the processor implementation. It is configured to hold double or String.<br>
	 * All keys are converted to upper case.
	 */
	public Map<String, Object> getSensorValuesWithKeyCapitalized() {
		Map<String, Object> capitalizedSensorValues = new HashMap<String, Object>();
		for (String sensorName : sensorValues.keySet()) {
			capitalizedSensorValues.put(sensorName.toUpperCase(), sensorValues.get(sensorName));
		}
		return capitalizedSensorValues;
	}

	public void setSensorValues(Map<String, Object> sensorValues) {
		this.sensorValues = sensorValues;
	}

	/**
	 * The key represents the Device Type's sensor name while the value represents the real sensor value received from a certain device the key is added after retrieving data from GeoEvent Data Definition in the processor implementation. It is configured to hold double or String.
	 */
	public void addSensorValue(String sensorName, Object value) {
		this.sensorValues.put(sensorName, value);
	}

	/**
	 * For test purposes.
	 * 
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static List<EventData> createWithDummyData(String filePath) throws NumberFormatException, IOException {
		EventData eventData = null;
		String line = "";
		BufferedReader test_data = new BufferedReader(new FileReader(new File(filePath)));
		List<EventData> eventDatas = new ArrayList<EventData>();
		while ((line = test_data.readLine()) != null) {
			String[] tokens = line.split(",");
			if (tokens[0].equals(""))
				continue;
			eventData = new EventData(tokens[0], new Double(tokens[1].trim()), new Double(tokens[2].trim()), new Integer(tokens[3].trim()), new Double(tokens[4].trim()));
			Map<String, Object> sensorValues = new HashMap<String, Object>();
			sensorValues.put("SPEED", new Double(tokens[5].trim()));
			sensorValues.put("TEMPERATURE", new Double(tokens[6].trim()));
			sensorValues.put("SEAT BELT", tokens[7]);
			eventData.setSensorValues(sensorValues);
			eventDatas.add(eventData);
		}
		return eventDatas;
	}

	@Override
	public String toString() {
		return "EventData [serial=" + serial + ", feedDateTime=" + feedDateTime + ", xCoord=" + xCoord + ", yCoord=" + yCoord + ", speed=" + speed + ", heading=" + heading + ", zone=" + zone + ", sensorValues=" + sensorValues + "]";
	}

}
