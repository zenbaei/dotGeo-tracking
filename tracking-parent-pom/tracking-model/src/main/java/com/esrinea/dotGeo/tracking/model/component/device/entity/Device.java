package com.esrinea.dotGeo.tracking.model.component.device.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

/**
 * The persistent class for the Tracking_Devices database table.
 * 
 */
@Entity
@Table(name = "Tracking_Devices")
@NamedNativeQuery(name = "Device.findById", query = "SELECT dev.* FROM Tracking_Devices dev JOIN Tracking_Device_Types devType ON dev.DeviceType_DBID = devType.DeviceType_DBID "
		+ "LEFT JOIN Sensors sens ON devType.DeviceType_DBID = sens.DeviceType_DBID " + "WHERE dev.Device_DBID = ? AND dev.isRetired = 0 AND sens.isRetired = 1")
@NamedQueries({ @NamedQuery(name = "Device.findByIdRetired", query = "SELECT d FROM Device d WHERE d.id = :id AND d.retired = :retired"),
		@NamedQuery(name = "Device.findBySerialRetired", query = "SELECT d FROM Device d WHERE d.serial = :serial AND d.retired = :retired") })
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Device_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "Serial")
	private String serial;

	@Column(name = "IsRetired")
	private boolean retired;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeviceType_DBID")
	private DeviceType deviceType;

	@OneToOne(fetch = FetchType.EAGER, mappedBy="device")
	private Resource resource;

	public Device() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isRetired() {
		return retired;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public Resource getResource() {
		return resource;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", serial=" + serial + ", retired=" + retired + ", deviceType=" + deviceType + ", resource=" + resource + "]";
	}

}