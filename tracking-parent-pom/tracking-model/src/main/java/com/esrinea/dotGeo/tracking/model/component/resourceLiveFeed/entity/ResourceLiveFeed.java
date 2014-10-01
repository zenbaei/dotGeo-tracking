package com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

/**
 * The persistent class for the Tracking_Resource_LiveFeeds database table.
 * 
 */
@Entity
@Table(name = "Tracking_Resource_LiveFeeds")
@NamedQuery(name = "ResourceLiveFeed.findByDevice", query = "SELECT r FROM ResourceLiveFeed r WHERE r.device.id = :deviceId")
public class ResourceLiveFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@TableGenerator(name = "resourceLiveFeed", table = "SEQUENCE_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "RESOURCE_LIVE_FEEDS", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "resourceLiveFeed")
	private int id;

	@Column(name = "Device")
	@ManyToOne
	@JoinColumn(name = "Device_DBID")
	private Device device;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FeedDateTime", nullable = false)
	private Date feedDateTime;

	@Column(name = "Heading", precision = 53)
	private double heading;

	@Column(name = "Speed")
	private int speed;

	@Column(name = "X_Coord", precision = 53)
	private double xCoord;

	@Column(name = "Y_Coord", precision = 53)
	private double yCoord;

	@Column(name = "Zone")
	private String zone;

	public ResourceLiveFeed() {
	}

	public ResourceLiveFeed(Device device, Date feedDateTime,
			double xCoord, double yCoord, int speed, double heading, String zone) {
		this.device = device;
		this.feedDateTime = feedDateTime;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.speed = speed;
		this.heading = heading;
		this.zone = zone;
	}

	public int getId() {
		return id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getFeedDateTime() {
		return feedDateTime;
	}
	
	public void setFeedDateTime(Date feedDateTime) {
		this.feedDateTime = feedDateTime;
	}

	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "ResourceLiveFeed [id=" + id + ", device=" + device
				+ ", feedDateTime=" + feedDateTime + ", heading=" + heading
				+ ", speed=" + speed + ", xCoord=" + xCoord + ", yCoord="
				+ yCoord + ", zone=" + zone + "]";
	}

}