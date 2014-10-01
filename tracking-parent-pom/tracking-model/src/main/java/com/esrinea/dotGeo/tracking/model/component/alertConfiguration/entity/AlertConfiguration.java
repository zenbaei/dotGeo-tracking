package com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

/**
 * The persistent class for the Alert_Configuration database table.
 * 
 */
@Entity
@Table(name = "Alert_Configuration")
@NamedQuery(name = "AlertConfiguration.findAll", query = "SELECT a FROM AlertConfiguration a")
public class AlertConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "AlertConfig_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "IsRetired")
	private boolean retired;

	@ManyToOne
	@JoinColumn(name = "Alert_DBID", nullable = false)
	private Alert alert;

	@ManyToOne
	@JoinColumn(name = "SensorConfig_DBID", nullable = false)
	private SensorConfiguration sensorConfiguration;

	public AlertConfiguration() {
	}

	public int getId() {
		return id;
	}

	public boolean isRetired() {
		return retired;
	}

	public SensorConfiguration getSensorConfiguration() {
		return sensorConfiguration;
	}

	@Override
	public String toString() {
		return "AlertConfiguration [id=" + id + ", retired=" + retired
				+ ", alert=" + alert + ", sensorConfiguration="
				+ sensorConfiguration + "]";
	}
	
	

}