package com.esrinea.dotGeo.tracking.model.component.alert.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the Alerts database table.
 * 
 */
@Entity
@Table(name = "Alerts")
@NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Alert_DBID", unique = true, nullable = false)
	private int alert_DBID;

	@Column(name = "Color")
	private Object color;

	@Column(name = "Created_By")
	private int created_By;

	@Column(name = "Creation_Date")
	private Timestamp creation_Date;

	@Column(name = "Icon")
	private Object icon;

	@Column(name = "IsRetired")
	private boolean isRetired;

	@Column(name = "Modification_Date")
	private Timestamp modification_Date;

	@Column(name = "Modified_By")
	private int modified_By;

	@Column(name = "Name_Ar")
	private Object name_Ar;

	@Column(name = "Name_En")
	private Object name_En;

	// bi-directional many-to-one association to AlertConfiguration
	@OneToMany(mappedBy = "alert", fetch = FetchType.EAGER)
	private List<AlertConfiguration> alertConfigurations;

	// bi-directional many-to-one association to TrackingDeviceType
	@ManyToOne
	@JoinColumn(name = "DeviceType_DBID", nullable = false)
	private DeviceType trackingDeviceType;

	// bi-directional many-to-one association to ResourceExecludedAlert
	@OneToMany(mappedBy = "alert", fetch = FetchType.EAGER)
	private List<ExecludedAlert> resourceExecludedAlerts;

	public Alert() {
	}

	public int getAlert_DBID() {
		return this.alert_DBID;
	}

	public void setAlert_DBID(int alert_DBID) {
		this.alert_DBID = alert_DBID;
	}

	public Object getColor() {
		return this.color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public int getCreated_By() {
		return this.created_By;
	}

	public void setCreated_By(int created_By) {
		this.created_By = created_By;
	}

	public Timestamp getCreation_Date() {
		return this.creation_Date;
	}

	public void setCreation_Date(Timestamp creation_Date) {
		this.creation_Date = creation_Date;
	}

	public Object getIcon() {
		return this.icon;
	}

	public void setIcon(Object icon) {
		this.icon = icon;
	}

	public boolean getIsRetired() {
		return this.isRetired;
	}

	public void setIsRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}

	public Timestamp getModification_Date() {
		return this.modification_Date;
	}

	public void setModification_Date(Timestamp modification_Date) {
		this.modification_Date = modification_Date;
	}

	public int getModified_By() {
		return this.modified_By;
	}

	public void setModified_By(int modified_By) {
		this.modified_By = modified_By;
	}

	public Object getName_Ar() {
		return this.name_Ar;
	}

	public void setName_Ar(Object name_Ar) {
		this.name_Ar = name_Ar;
	}

	public Object getName_En() {
		return this.name_En;
	}

	public void setName_En(Object name_En) {
		this.name_En = name_En;
	}

	public List<AlertConfiguration> getAlertConfigurations() {
		return this.alertConfigurations;
	}

	public void setAlertConfigurations(
			List<AlertConfiguration> alertConfigurations) {
		this.alertConfigurations = alertConfigurations;
	}

	public AlertConfiguration addAlertConfiguration(
			AlertConfiguration alertConfiguration) {
		getAlertConfigurations().add(alertConfiguration);
		alertConfiguration.setAlert(this);

		return alertConfiguration;
	}

	public AlertConfiguration removeAlertConfiguration(
			AlertConfiguration alertConfiguration) {
		getAlertConfigurations().remove(alertConfiguration);
		alertConfiguration.setAlert(null);

		return alertConfiguration;
	}

	public DeviceType getTrackingDeviceType() {
		return this.trackingDeviceType;
	}

	public void setTrackingDeviceType(DeviceType trackingDeviceType) {
		this.trackingDeviceType = trackingDeviceType;
	}

	public List<ExecludedAlert> getResourceExecludedAlerts() {
		return this.resourceExecludedAlerts;
	}

	public void setResourceExecludedAlerts(
			List<ExecludedAlert> resourceExecludedAlerts) {
		this.resourceExecludedAlerts = resourceExecludedAlerts;
	}

	public ExecludedAlert addResourceExecludedAlert(
			ExecludedAlert resourceExecludedAlert) {
		getResourceExecludedAlerts().add(resourceExecludedAlert);
		resourceExecludedAlert.setAlert(this);

		return resourceExecludedAlert;
	}

	public ExecludedAlert removeResourceExecludedAlert(
			ExecludedAlert resourceExecludedAlert) {
		getResourceExecludedAlerts().remove(resourceExecludedAlert);
		resourceExecludedAlert.setAlert(null);

		return resourceExecludedAlert;
	}

}