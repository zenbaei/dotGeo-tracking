package com.esrinea.dotGeo.tracking.model.component.device.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hamcrest.core.Is;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

/**
 * The persistent class for the Tracking_Devices database table.
 * 
 */
@Entity
@Table(name = "Tracking_Devices")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Device_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "IsRetired")
	private boolean isRetired;

	@ManyToOne
	@JoinColumn(name = "DeviceType_DBID")
	private DeviceType deviceType;

	@OneToOne
	@JoinColumn(name = "Device_DBID")
	private Resource resource;

	public Device() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean isRetired() {
		return isRetired;
	}
	
	public void setRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}