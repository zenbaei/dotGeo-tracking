package com.esrinea.dotGeo.tracking.model.component.resource.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;

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

	@OneToMany(mappedBy = "trackingResource", fetch = FetchType.EAGER)
	private List<ExecludedAlert> resourceExecludedAlerts;

	@OneToMany(mappedBy = "resource", fetch = FetchType.EAGER)
	private List<ExecludedSensor> execludedSensors;

	@ManyToOne
	@JoinColumn(name = "Device_DBID", nullable = false)
	private Device device;

	public Resource() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ExecludedSensor> getExecludedSensors() {
		return execludedSensors;
	}

	public void setExecludedSensors(List<ExecludedSensor> execludedSensors) {
		this.execludedSensors = execludedSensors;
	}
}