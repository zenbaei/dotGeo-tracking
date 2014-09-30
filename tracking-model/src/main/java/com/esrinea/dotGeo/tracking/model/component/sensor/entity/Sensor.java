package com.esrinea.dotGeo.tracking.model.component.sensor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

/**
 * The persistent class for the Sensors database table.
 * 
 */
@Entity
@Table(name = "Sensors")
@NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Sensor_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "IsRetired")
	private boolean isRetired;

	@Column(name = "Name_En")
	private String nameEn;

	@OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
	private List<SensorConfiguration> sensorConfigurations;

	@ManyToOne
	@JoinColumn(name = "DeviceType_DBID")
	private DeviceType deviceType;

	public Sensor() {
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public boolean isRetired() {
		return isRetired;
	}

	public void setRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}

	public List<SensorConfiguration> getSensorConfigurations() {
		return sensorConfigurations;
	}

	public void setSensorConfigurations(
			List<SensorConfiguration> sensorConfigurations) {
		this.sensorConfigurations = sensorConfigurations;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
}