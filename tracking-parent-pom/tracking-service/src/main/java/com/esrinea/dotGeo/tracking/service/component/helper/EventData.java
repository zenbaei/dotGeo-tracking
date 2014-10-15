package com.esrinea.dotGeo.tracking.service.component.helper;

import java.util.Date;
import java.util.Map;

/**
 * Data received from GeoEvent will be set in that object
 * 
 * @author islam.zenbaei
 *
 */
public class EventData {

	private int deviceId;
	private Date feedDateTime;
	private double xCoord;
	private double yCoord;
	private int speed;
	private double heading;
	private String zone;
	private Map<String, String> sensorValues; // sensor data received from GeoEvent

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
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

	public Map<String, String> getSensorValues() {
		return sensorValues;
	}

	public void setSensorValues(Map<String, String> sensorValues) {
		this.sensorValues = sensorValues;
	}

}
