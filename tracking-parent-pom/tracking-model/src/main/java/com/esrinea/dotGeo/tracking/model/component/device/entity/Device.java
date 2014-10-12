package com.esrinea.dotGeo.tracking.model.component.device.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
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
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "Device_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "IsRetired")
	private boolean retired;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "DeviceType_DBID")
	private DeviceType deviceType;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Device_DBID")
	private Resource resource;

	public Device() {
	}

	public int getId() {
		return id;
	}

	public boolean isRetired() {
		return retired;
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
		return "Device [id=" + id + ", retired=" + retired + ", deviceType=" + deviceType + ", resource=" + resource + "]";
	}

}