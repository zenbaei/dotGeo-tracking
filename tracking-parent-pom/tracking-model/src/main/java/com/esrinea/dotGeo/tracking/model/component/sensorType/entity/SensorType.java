package com.esrinea.dotGeo.tracking.model.component.sensorType.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sensor_Types")
public class SensorType implements Serializable {

	private static final long serialVersionUID = -7570462376610694687L;
	
	public static enum Type{GeoFence}

	@Id
	@Column(name = "Sensor_Type_DBID")
	private int id;
	
	@Column(name="SensorType_Description")
	private String description;

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "SensorType [id=" + id + ", description=" + description + "]";
	}
	
	

}
