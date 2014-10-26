package com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the Tracking_Alert_Sensor_LiveFeeds database table.
 * 
 */
@Entity
@IdClass(value=AlertSensorLiveFeedId.class)
@Table(name="Tracking_Alert_Sensor_LiveFeeds")
@NamedQuery(name="Tracking_Alert_Sensor_LiveFeed.findAll", query="SELECT t FROM AlertSensorLiveFeed t")
public class AlertSensorLiveFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Alert_LiveFeeds_DBID")
	private int alertLiveFeedId;

	@Id
	@Column(name="Sensor_LiveFeeds_DBID")
	private int sensorLiveFeedId;

	public AlertSensorLiveFeed() {
	}

	public AlertSensorLiveFeed(AlertSensorLiveFeedId alertSensorLiveFeedId) {
		this.alertLiveFeedId = alertSensorLiveFeedId.getAlertLiveFeedId();
		this.sensorLiveFeedId = alertSensorLiveFeedId.getSensorLiveFeedId();
	}

	@Override
	public String toString() {
		return "AlertSensorLiveFeed [alertLiveFeedId=" + alertLiveFeedId + ", sensorLiveFeedId=" + sensorLiveFeedId + "]";
	}

	

}