package com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

import java.sql.Timestamp;


/**
 * The persistent class for the Alert_Configuration database table.
 * 
 */
@Entity
@Table(name="Alert_Configuration")
@NamedQuery(name="AlertConfiguration.findAll", query="SELECT a FROM AlertConfiguration a")
public class AlertConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "alertConfiguration", table = "SEQ_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "ALERT_CONFIGS", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "alertConfiguration")
	@Column(name="AlertConfig_DBID", unique=true, nullable=false)
	private int alertConfig_DBID;

	@Column(name="Comments")
	private Object comments;

	@Column(name="Created_By")
	private int created_By;

	@Column(name="Creation_Date")
	private Timestamp creation_Date;

	@Column(name="IsRetired")
	private boolean isRetired;

	@Column(name="Modification_Date")
	private Timestamp modification_Date;

	@Column(name="Modified_By")
	private int modified_By;

	//bi-directional many-to-one association to Alert
	@ManyToOne
	@JoinColumn(name="Alert_DBID", nullable=false)
	private Alert alert;

	//bi-directional many-to-one association to SensorConfiguration
	@ManyToOne
	@JoinColumn(name="SensorConfig_DBID", nullable=false)
	private SensorConfiguration sensorConfiguration;

	public AlertConfiguration() {
	}

	public int getAlertConfig_DBID() {
		return this.alertConfig_DBID;
	}

	public void setAlertConfig_DBID(int alertConfig_DBID) {
		this.alertConfig_DBID = alertConfig_DBID;
	}

	public Object getComments() {
		return this.comments;
	}

	public void setComments(Object comments) {
		this.comments = comments;
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

	public Alert getAlert() {
		return this.alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public SensorConfiguration getSensorConfiguration() {
		return this.sensorConfiguration;
	}

	public void setSensorConfiguration(SensorConfiguration sensorConfiguration) {
		this.sensorConfiguration = sensorConfiguration;
	}

}