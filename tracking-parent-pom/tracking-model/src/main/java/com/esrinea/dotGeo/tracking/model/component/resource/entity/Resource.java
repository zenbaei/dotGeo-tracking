package com.esrinea.dotGeo.tracking.model.component.resource.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

/**
 * The persistent class for the Tracking_Resources database table.
 * 
 */
@Entity
@Table(name = "Tracking_Resources")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Resource_DBID", unique = true, nullable = false)
	private int id;

	@OneToMany(mappedBy = "resource", fetch = FetchType.EAGER)
	@MapKeyJoinColumn(name = "Alert_DBID")
	private Map<Alert, ExecludedAlert> execludedAlerts;

	@OneToMany(mappedBy = "resource", fetch = FetchType.EAGER)
	@MapKeyJoinColumn(name = "Sensor_DBID")
	private Map<Sensor, ExecludedSensor> execludedSensors;

	@ManyToOne
	@JoinColumn(name = "Device_DBID", nullable = false)
	private Device device;

	public Resource() {
	}

	public int getId() {
		return id;
	}

	public Map<Sensor, ExecludedSensor> getExecludedSensors() {
		return execludedSensors;
	}

	public Map<Alert, ExecludedAlert> getExecludedAlerts() {
		return execludedAlerts;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + "]";
	}

}