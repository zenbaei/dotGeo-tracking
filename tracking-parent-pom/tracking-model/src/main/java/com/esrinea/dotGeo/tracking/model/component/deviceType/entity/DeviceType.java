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

	private List<Sensor> sensors = new ArrayList<Sensor>();

	private List<Alert> alerts = new ArrayList<Alert>();

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

	@OneToMany(mappedBy = "deviceType", fetch = FetchType.LAZY)
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public void addSensor(Sensor sensor) {
		if (!sensors.contains(sensor)) {
			sensors.add(sensor);
		}
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	@OneToMany(mappedBy = "deviceType", fetch = FetchType.LAZY)
	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public void addAlert(Alert alert) {
		if (!alerts.contains(alert)) {
			alerts.add(alert);
		}
	}

	public boolean isRetired() {
		return retired;
	}

	@Override
	public String toString() {
		return "DeviceType [id=" + id + ", sensors=" + sensors + ", alerts=" + alerts + ", retired=" + retired + "]\n";
	}

}