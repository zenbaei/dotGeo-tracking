package com.esrinea.dotGeo.tracking.model.component.deviceType.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

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

	@OneToMany(mappedBy = "deviceType", fetch = FetchType.EAGER)
	private List<Sensor> sensors;

	@OneToMany(mappedBy = "deviceType", fetch = FetchType.EAGER)
	private List<Alert> alerts;

	public DeviceType() {
	}

	public int getId() {
		return id;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	@Override
	public String toString() {
		return "DeviceType [id=" + id + "]";
	}

}