package com.esrinea.dotGeo.tracking.model.component.sensor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorType.entity.SensorType;

/**
 * The persistent class for the Sensors database table.
 * 
 */
@Entity
@Table(name = "Sensors")
@NamedQueries({ @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s"),
	@NamedQuery(name = "Sensor.findByNameEn", query = "SELECT s FROM Sensor s WHERE s.nameEn = :sensorNameEn"),
		@NamedQuery(name = "Sensor.findByDeviceTypeRetired", query = "SELECT s FROM Sensor s WHERE s.deviceType.id = :id AND s.retired = :retired") })
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Sensor_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "IsRetired")
	private boolean retired;

	@Column(name = "Name_En")
	private String nameEn;

	@OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
	private List<SensorConfiguration> sensorConfigurations;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeviceType_DBID")
	private DeviceType deviceType;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Sensor_Type_DBID")
	private SensorType sensorType;

	
	public int getId() {
		return id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public boolean isRetired() {
		return retired;
	}

	public List<SensorConfiguration> getSensorConfigurations() {
		return sensorConfigurations;
	}

	public void setSensorConfigurations(List<SensorConfiguration> sensorConfigurations) {
		this.sensorConfigurations = sensorConfigurations;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nameEn == null) ? 0 : nameEn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		if (id != other.id)
			return false;
		if (nameEn == null) {
			if (other.nameEn != null)
				return false;
		} else if (!nameEn.equals(other.nameEn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", retired=" + retired + ", nameEn=" + nameEn + ", sensorType=" + sensorType + "]";
	}


}