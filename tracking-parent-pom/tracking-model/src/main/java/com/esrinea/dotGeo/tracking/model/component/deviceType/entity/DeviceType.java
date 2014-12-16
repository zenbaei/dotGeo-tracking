package com.esrinea.dotGeo.tracking.model.component.deviceType.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({ @NamedQuery(name = "DeviceType.findByRetired", query = "SELECT d FROM DeviceType d WHERE d.retired = :retired"),
		@NamedQuery(name = "DeviceType.findByIdRetired", query = "SELECT d FROM DeviceType d WHERE d.id = :id AND d.retired = :retired") })
public class DeviceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DeviceType_DBID", unique = true, nullable = false)
	private int id;

	@OneToMany(mappedBy = "deviceType", fetch = FetchType.LAZY)
	private List<Sensor> sensors;

	@OneToMany(mappedBy = "deviceType", fetch = FetchType.LAZY)
	private List<Alert> alerts;

	@Column(name = "IsRetired")
	private boolean retired;

	@Column(name = "DeviceType_Desc")
	private String desc;

	public String getDesc() {
		return desc;
	}

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

	public void addSensor(Sensor sensor) {
		if (sensors == null) {
			sensors = new ArrayList<Sensor>();
		}
		sensors.add(sensor);
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public void addAlert(Alert alert) {
		if (alerts == null) {
			alerts = new ArrayList<Alert>();
		}
		alerts.add(alert);
	}

	public boolean isRetired() {
		return retired;
	}

	@Override
	public String toString() {
		return "DeviceType [id=" + id + ", sensors=" + sensors + ", alerts=" + alerts + ", retired=" + retired + "]\n";
	}

}