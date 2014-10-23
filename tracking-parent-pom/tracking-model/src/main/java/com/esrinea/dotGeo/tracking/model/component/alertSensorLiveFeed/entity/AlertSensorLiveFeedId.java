package com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity;

import java.io.Serializable;

public class AlertSensorLiveFeedId implements Serializable {

	private static final long serialVersionUID = 699563227519485608L;
	private int alertLiveFeedId;
	private int sensorLiveFeedId;
	
	public AlertSensorLiveFeedId() {
	}
	
	public AlertSensorLiveFeedId(int alertLiveFeedId, int sensorLiveFeedId) {
		super();
		this.alertLiveFeedId = alertLiveFeedId;
		this.sensorLiveFeedId = sensorLiveFeedId;
	}


	public int getAlertLiveFeedId() {
		return alertLiveFeedId;
	}


	public void setAlertLiveFeedId(int alertLiveFeedId) {
		this.alertLiveFeedId = alertLiveFeedId;
	}


	public int getSensorLiveFeedId() {
		return sensorLiveFeedId;
	}


	public void setSensorLiveFeedId(int sensorLiveFeedId) {
		this.sensorLiveFeedId = sensorLiveFeedId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alertLiveFeedId;
		result = prime * result + sensorLiveFeedId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlertSensorLiveFeedId other = (AlertSensorLiveFeedId) obj;
		if (alertLiveFeedId != other.alertLiveFeedId)
			return false;
		if (sensorLiveFeedId != other.sensorLiveFeedId)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
