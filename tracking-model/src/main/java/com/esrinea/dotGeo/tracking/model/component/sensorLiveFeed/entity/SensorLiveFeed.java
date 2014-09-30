package com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Sensors_LiveFeeds database table.
 * 
 */
@Entity
@Table(name="Sensors_LiveFeeds")
@NamedQuery(name="SensorsLiveFeed.findAll", query="SELECT s FROM SensorLiveFeed s")
public class SensorLiveFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "sensorsLiveFeed", table = "SEQ_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "ALERT_CONFIGS", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sensorsLiveFeed")
	@Column(name="Sensor_LiveFeeds_DBID", unique=true, nullable=false)
	private int sensor_LiveFeeds_DBID;

	@Column(name="Device")
	private Object device;

	@Column(name="Device_DBID")
	private int device_DBID;

	@Column(name="Sensor_ArDesc")
	private Object sensor_ArDesc;

	@Column(name="Sensor_DateTime")
	private Timestamp sensor_DateTime;

	@Column(name="Sensor_EnDesc")
	private Object sensor_EnDesc;

	@Column(name="Sensor_Value")
	private Object sensor_Value;

	@Column(name="SensorConfigDBID")
	private int sensorConfigDBID;

	public SensorLiveFeed() {
	}

	public int getSensor_LiveFeeds_DBID() {
		return this.sensor_LiveFeeds_DBID;
	}

	public void setSensor_LiveFeeds_DBID(int sensor_LiveFeeds_DBID) {
		this.sensor_LiveFeeds_DBID = sensor_LiveFeeds_DBID;
	}

	public Object getDevice() {
		return this.device;
	}

	public void setDevice(Object device) {
		this.device = device;
	}

	public int getDevice_DBID() {
		return this.device_DBID;
	}

	public void setDevice_DBID(int device_DBID) {
		this.device_DBID = device_DBID;
	}

	public Object getSensor_ArDesc() {
		return this.sensor_ArDesc;
	}

	public void setSensor_ArDesc(Object sensor_ArDesc) {
		this.sensor_ArDesc = sensor_ArDesc;
	}

	public Timestamp getSensor_DateTime() {
		return this.sensor_DateTime;
	}

	public void setSensor_DateTime(Timestamp sensor_DateTime) {
		this.sensor_DateTime = sensor_DateTime;
	}

	public Object getSensor_EnDesc() {
		return this.sensor_EnDesc;
	}

	public void setSensor_EnDesc(Object sensor_EnDesc) {
		this.sensor_EnDesc = sensor_EnDesc;
	}

	public Object getSensor_Value() {
		return this.sensor_Value;
	}

	public void setSensor_Value(Object sensor_Value) {
		this.sensor_Value = sensor_Value;
	}

	public int getSensorConfigDBID() {
		return this.sensorConfigDBID;
	}

	public void setSensorConfigDBID(int sensorConfigDBID) {
		this.sensorConfigDBID = sensorConfigDBID;
	}

}