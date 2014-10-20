package com.esrinea.dotGeo.tracking.service.common.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Sets;

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
	private Map<String, Object> sensorValues =  new HashMap<String, Object>(); // sensor data received from GeoEvent
	
	

	public EventData(int deviceId, double xCoord, double yCoord, int speed, double heading, Map<String, Object> sensorValues) {
		this.deviceId = deviceId;
		this.feedDateTime = new Date();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.speed = speed;
		this.heading = heading;
		this.sensorValues = sensorValues;
	}
	
	public EventData(int deviceId, double xCoord, double yCoord, int speed, double heading) {
		this.deviceId = deviceId;
		this.feedDateTime = new Date();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.speed = speed;
		this.heading = heading;
	}

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

	/**
	 * it is configured to hold double or String
	 */
	public Map<String, Object> getSensorValues() {
		return sensorValues;
	}
	
	public void addSensorValue(String sensorName, Object value){
		this.sensorValues.put(sensorName, value);
	}

	@Override
	public String toString() {
		return "EventData [deviceId=" + deviceId + ", feedDateTime=" + feedDateTime + ", xCoord=" + xCoord + ", yCoord=" + yCoord + ", speed=" + speed + ", heading=" + heading + ", zone=" + zone + ", sensorValues=" + sensorValues + "]";
	}
	
	

}
