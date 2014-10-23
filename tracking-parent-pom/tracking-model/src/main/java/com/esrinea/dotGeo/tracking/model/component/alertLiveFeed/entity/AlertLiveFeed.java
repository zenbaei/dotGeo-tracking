package com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

/**
 * The persistent class for the Alert_LiveFeeds database table.
 * 
 */
@Entity
@Table(name = "Alert_LiveFeeds")
@NamedQueries({
@NamedQuery(name = "AlertLiveFeed.findAll", query = "SELECT a FROM AlertLiveFeed a"),
@NamedQuery(name = "AlertLiveFeed.findByAlert", query = "SELECT a FROM AlertLiveFeed a WHERE a.alert.id = :alertId"),
}) 
public class AlertLiveFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "alertLiveFeed", table = "SEQUENCE_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "ALERT_LIVE_FEEDS", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "alertLiveFeed")
	@Column(name = "ALERT_LIVEFEEDS_ID", unique = true, nullable = false)
	private int id;

	@Column(name = "Alert_DateTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date feedDateTime;

	@ManyToOne
	@JoinColumn(name = "Alert_DBID", nullable = false)
	private Alert alert;

	@ManyToOne
	@JoinColumn(name = "Device_DBID", nullable = false)
	private Device device;

	@Column(name="Zone")
	private String zone;

	public AlertLiveFeed() {
	}

	public AlertLiveFeed(Device device, Alert alert, Date feedDateTime, String zone) {
		this.device = device;
		this.alert = alert;
		this.feedDateTime = feedDateTime;
		this.zone = zone;
	}
	
	public int getId() {
		return id;
	}
	
	public Alert getAlert() {
		return alert;
	}

	@Override
	public String toString() {
		return "AlertLiveFeed [id=" + id + ", feedDateTime=" + feedDateTime + ", alert=" + alert + ", device=" + device + ", zone=" + zone + "]";
	}
	
	

}