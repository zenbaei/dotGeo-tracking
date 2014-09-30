package com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Alert_LiveFeeds database table.
 * 
 */
@Entity
@Table(name="Alert_LiveFeeds")
@NamedQuery(name="AlertLiveFeed.findAll", query="SELECT a FROM AlertLiveFeed a")
public class AlertLiveFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "alertLiveFeed", table = "SEQ_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "ALERT_CONFIGS", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "alertLiveFeed")
	@Column(name="Alert_LiveFeeds_DBID", unique=true, nullable=false)
	private int alert_LiveFeeds_DBID;

	@Column(name="Alert_DateTime", nullable=false)
	private Timestamp alert_DateTime;

	@Column(name="Alert_DBID", nullable=false)
	private int alert_DBID;

	@Column(name="AlertName_Ar")
	private Object alertName_Ar;

	@Column(name="AlertName_En")
	private Object alertName_En;

	@Column(name="Color")
	private Object color;

	@Column(name="CreationDate")
	private Timestamp creationDate;

	@Column(name="Device")
	private Object device;

	@Column(name="Device_DBID", nullable=false)
	private int device_DBID;

	@Column(name="Device_Type_DBID")
	private int device_Type_DBID;

	@Column(name="Groups_Ar")
	private Object groups_Ar;

	@Column(name="Groups_en")
	private Object groups_en;

	@Column(name="GroupsIDs")
	private Object groupsIDs;

	@Column(name="Icon")
	private Object icon;

	@Column(name="License")
	private Object license;

	@Column(name="PlateNumber")
	private Object plateNumber;

	@Column(name="Resource_DBID")
	private int resource_DBID;

	@Column(name="Resource_Type_ArDesc")
	private Object resource_Type_ArDesc;

	@Column(name="Resource_Type_DBID")
	private int resource_Type_DBID;

	@Column(name="Resource_Type_EnDesc")
	private Object resource_Type_EnDesc;

	@Column(name="Zone")
	private Object zone;

	@Column(name="ZoneGeo")
	private byte[] zoneGeo;

	public AlertLiveFeed() {
	}

	public int getAlert_LiveFeeds_DBID() {
		return this.alert_LiveFeeds_DBID;
	}

	public void setAlert_LiveFeeds_DBID(int alert_LiveFeeds_DBID) {
		this.alert_LiveFeeds_DBID = alert_LiveFeeds_DBID;
	}

	public Timestamp getAlert_DateTime() {
		return this.alert_DateTime;
	}

	public void setAlert_DateTime(Timestamp alert_DateTime) {
		this.alert_DateTime = alert_DateTime;
	}

	public int getAlert_DBID() {
		return this.alert_DBID;
	}

	public void setAlert_DBID(int alert_DBID) {
		this.alert_DBID = alert_DBID;
	}

	public Object getAlertName_Ar() {
		return this.alertName_Ar;
	}

	public void setAlertName_Ar(Object alertName_Ar) {
		this.alertName_Ar = alertName_Ar;
	}

	public Object getAlertName_En() {
		return this.alertName_En;
	}

	public void setAlertName_En(Object alertName_En) {
		this.alertName_En = alertName_En;
	}

	public Object getColor() {
		return this.color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Object getDevice() {
		return this.device;
	}

	public void setDevice(Object device) {
		this.device = device;
	}

	public int getDevice_DBID() {
		return this.device_DBID;
	}

	public void setDevice_DBID(int device_DBID) {
		this.device_DBID = device_DBID;
	}

	public int getDevice_Type_DBID() {
		return this.device_Type_DBID;
	}

	public void setDevice_Type_DBID(int device_Type_DBID) {
		this.device_Type_DBID = device_Type_DBID;
	}

	public Object getGroups_Ar() {
		return this.groups_Ar;
	}

	public void setGroups_Ar(Object groups_Ar) {
		this.groups_Ar = groups_Ar;
	}

	public Object getGroups_en() {
		return this.groups_en;
	}

	public void setGroups_en(Object groups_en) {
		this.groups_en = groups_en;
	}

	public Object getGroupsIDs() {
		return this.groupsIDs;
	}

	public void setGroupsIDs(Object groupsIDs) {
		this.groupsIDs = groupsIDs;
	}

	public Object getIcon() {
		return this.icon;
	}

	public void setIcon(Object icon) {
		this.icon = icon;
	}

	public Object getLicense() {
		return this.license;
	}

	public void setLicense(Object license) {
		this.license = license;
	}

	public Object getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(Object plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getResource_DBID() {
		return this.resource_DBID;
	}

	public void setResource_DBID(int resource_DBID) {
		this.resource_DBID = resource_DBID;
	}

	public Object getResource_Type_ArDesc() {
		return this.resource_Type_ArDesc;
	}

	public void setResource_Type_ArDesc(Object resource_Type_ArDesc) {
		this.resource_Type_ArDesc = resource_Type_ArDesc;
	}

	public int getResource_Type_DBID() {
		return this.resource_Type_DBID;
	}

	public void setResource_Type_DBID(int resource_Type_DBID) {
		this.resource_Type_DBID = resource_Type_DBID;
	}

	public Object getResource_Type_EnDesc() {
		return this.resource_Type_EnDesc;
	}

	public void setResource_Type_EnDesc(Object resource_Type_EnDesc) {
		this.resource_Type_EnDesc = resource_Type_EnDesc;
	}

	public Object getZone() {
		return this.zone;
	}

	public void setZone(Object zone) {
		this.zone = zone;
	}

	public byte[] getZoneGeo() {
		return this.zoneGeo;
	}

	public void setZoneGeo(byte[] zoneGeo) {
		this.zoneGeo = zoneGeo;
	}

}