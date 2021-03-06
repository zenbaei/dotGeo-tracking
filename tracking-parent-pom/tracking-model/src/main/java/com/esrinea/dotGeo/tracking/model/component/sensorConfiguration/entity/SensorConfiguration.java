package com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

/**
 * The persistent class for the Sensor_Configuration database table.
 * 
 */
@Entity
@Table(name = "Sensor_Configuration")
@NamedQueries({
		@NamedQuery(name = "SensorConfiguration.findAll", query = "SELECT s FROM SensorConfiguration s"),
		@NamedQuery(name = "SensorConfiguration.findBySensorIdRetired", query = "SELECT s FROM SensorConfiguration s WHERE s.sensor.id = :sensorId AND s.retired = :retired") })
public class SensorConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SensorConfig_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "Config_Text")
	private String configText;

	@Column(name = "MaxValue", precision = 53)
	private double maxValue;

	@Column(name = "MinValue", precision = 53)
	private double minValue;

	@Column(name = "TextValue")
	private String textValue;

	@ManyToOne
	@JoinColumn(name = "Sensor_DBID")
	private Sensor sensor;

	@Column(name = "IsRetired")
	private boolean retired;

	public SensorConfiguration() {
	}

	public double getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return this.minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public String getConfigText() {
		return configText;
	}

	public void setConfigText(String configText) {
		this.configText = configText;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "SensorConfiguration [id=" + id + ", configText=" + configText + ", maxValue=" + maxValue + ", minValue=" + minValue + ", textValue="
				+ textValue + ", sensor=" + sensor + ", retired=" + retired + "]";
	}

}