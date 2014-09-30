package com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;


/**
 * The persistent class for the Sensor_Configuration database table.
 * 
 */
@Entity
@Table(name="Sensor_Configuration")
@NamedQuery(name="SensorConfiguration.findAll", query="SELECT s FROM SensorConfiguration s")
public class SensorConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SensorConfig_DBID", unique=true, nullable=false)
	private int id;

	@Column(name="Config_Text")
	private String configText;

	@Column(name="MaxValue", precision=53)
	private double maxValue;

	@Column(name="MinValue", precision=53)
	private double minValue;

	@Column(name="TextValue")
	private String textValue;

	@OneToMany(mappedBy="sensorConfiguration", fetch=FetchType.EAGER)
	private List<AlertConfiguration> alertConfigurations;

	@ManyToOne
	@JoinColumn(name="Sensor_DBID")
	private Sensor sensor;

	public SensorConfiguration() {
	}

	public double getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return this.minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public String getTextValue() {
		return textValue;
	}
	
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

}