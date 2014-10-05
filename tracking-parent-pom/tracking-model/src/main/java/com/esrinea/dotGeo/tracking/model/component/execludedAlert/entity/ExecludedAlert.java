package com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;


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
	private int id;

	@ManyToOne
	@JoinColumn(name="Alert_DBID", nullable=false)
	private Alert alert;

	@ManyToOne
	@JoinColumn(name="Resource_DBID", nullable=false)
	private Resource resource;

	public ExecludedAlert() {
	}

	public int getId() {
		return id;
	}

	public Alert getAlert() {
		return alert;
	}

	@Override
	public String toString() {
		return "ExecludedAlert [id=" + id + ", alert=" + alert + ", resource="
				+ resource + "]";
	}

	

}