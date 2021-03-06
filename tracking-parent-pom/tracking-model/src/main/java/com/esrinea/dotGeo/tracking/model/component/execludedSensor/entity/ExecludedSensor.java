package com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;


/**
 * The persistent class for the Resource_Execluded_Sensors database table.
 * 
 */
@Entity
@Table(name="Resource_Execluded_Sensors")
public class ExecludedSensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ResExSensor_DBID", unique=true, nullable=false)
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Sensor_DBID", nullable=false)
	private Sensor sensor;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Resource_DBID", nullable=false)
	private Resource resource;

	public ExecludedSensor() {
	}

	public Sensor getSensor() {
		return this.sensor;
	}


	public Resource getResource() {
		return resource;
	}

	@Override
	public String toString() {
		return "ExecludedSensor [id=" + id + ", sensor=" + sensor
				+ ", resource=" + resource + "]";
	}
	

	

}