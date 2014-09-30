package com.esrinea.dotGeo.tracking.model.component.deviceType.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.google.common.collect.Sets;

/**
 * The persistent class for the Tracking_Device_Types database table.
 * 
 */
@Entity
@Table(name = "Tracking_Device_Types")
public class DeviceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DeviceType_DBID", unique = true, nullable = false)
	private int id;

	@OneToMany(mappedBy = "deviceType")
	private List<Sensor> sensors;

	public DeviceType() {
	}

	public int getId() {
		return id;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

}