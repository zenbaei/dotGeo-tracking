package com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

import java.sql.Timestamp;


/**
 * The persistent class for the Resource_Execluded_Alerts database table.
 * 
 */
@Entity
@Table(name="Resource_Execluded_Alerts")
public class ExecludedAlert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ResExAlerts_DBID", unique=true, nullable=false)
	private int resExAlerts_DBID;

	@Column(name="Created_By")
	private int created_By;

	@Column(name="Creation_Date")
	private Timestamp creation_Date;

	@Column(name="Modification_Date")
	private Timestamp modification_Date;

	@Column(name="Modified_By")
	private int modified_By;

	//bi-directional many-to-one association to Alert
	@ManyToOne
	@JoinColumn(name="Alert_DBID", nullable=false)
	private Alert alert;

	//bi-directional many-to-one association to TrackingResource
	@ManyToOne
	@JoinColumn(name="Resource_DBID", nullable=false)
	private Resource trackingResource;

	public ExecludedAlert() {
	}

	public int getResExAlerts_DBID() {
		return this.resExAlerts_DBID;
	}

	public void setResExAlerts_DBID(int resExAlerts_DBID) {
		this.resExAlerts_DBID = resExAlerts_DBID;
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

	public Resource getTrackingResource() {
		return this.trackingResource;
	}

	public void setTrackingResource(Resource trackingResource) {
		this.trackingResource = trackingResource;
	}

}