package com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

/**
 * The persistent class for the Sensors_LiveFeeds database table.
 * 
 */
@Entity
@Table(name = "Sensors_LiveFeeds")
@NamedQueries({ @NamedQuery(name = "SensorsLiveFeed.findAll", query = "SELECT s FROM SensorLiveFeed s"), 
	@NamedQuery(name = "SensorLiveFeed.findBySensorValue", query = "SELECT s FROM SensorLiveFeed s WHERE s.sensorValue = :sensorValue") })
public class SensorLiveFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "sensorLiveFeed", table = "SEQUENCE_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "SENSOR_LIVE_FEEDS", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sensorLiveFeed")
	@Column(name = "Sensor_LiveFeeds_DBID", unique = true, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "Device_DBID")
	private Device device;

	@Column(name = "Sensor_Value")
	private String sensorValue;

	@ManyToOne
	@JoinColumn(name = "SensorConfigDBID")
	private SensorConfiguration sensorConfiguration;

	@Column(name = "Sensor_DateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Column(name="Sensor_value")
	private String geoFenceLayerIdAndFenceId;

	public SensorLiveFeed() {
	}

	public SensorLiveFeed(Device device, SensorConfiguration sensorConfiguration, String sensorValue, Date dateTime, String geoFenceLayerIdAndFenceId) {
		this.sensorConfiguration = sensorConfiguration;
		this.device = device;
		this.sensorValue = sensorValue;
		this.dateTime = dateTime;
		this.geoFenceLayerIdAndFenceId = geoFenceLayerIdAndFenceId;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getSensorValue() {
		return sensorValue;
	}

	public void setSensorValue(String sensorValue) {
		this.sensorValue = sensorValue;
	}

	public SensorConfiguration getSensorConfiguration() {
		return sensorConfiguration;
	}

	public void setSensorConfiguration(SensorConfiguration sensorConfiguration) {
		this.sensorConfiguration = sensorConfiguration;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public String getGeoFenceLayerIdAndFenceId() {
		return geoFenceLayerIdAndFenceId;
	}
	
	@Override
	public String toString() {
		return "SensorLiveFeed [id=" + id + ", device=" + device + ", sensorValue=" + sensorValue + ", sensorConfiguration=" + sensorConfiguration + ", dateTime=" + dateTime + ", geoFenceLayerIdAndFenceId="+ geoFenceLayerIdAndFenceId + "]";
	}

	
}