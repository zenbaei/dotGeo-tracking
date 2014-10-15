package com.esrinea.dotGeo.tracking.model.component.alert.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

/**
 * The persistent class for the Alerts database table.
 * 
 */
@Entity
@Table(name = "Alerts")
@NamedQueries({
		@NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
		@NamedQuery(name = "Alert.findByDeviceTypeRetired", query = "SELECT a FROM Alert a WHERE a.deviceType.id = :deviceTypeId AND a.retired = :retired"),
})
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Alert_DBID", unique = true, nullable = false)
	private int id;

	@Column(name = "IsRetired")
	private boolean retired;

	@Column(name = "Name_En")
	private String nameEn;

	@OneToMany(mappedBy = "alert", fetch = FetchType.LAZY)
	private List<AlertConfiguration> alertConfigurations;

	@ManyToOne
	@JoinColumn(name = "DeviceType_DBID", nullable = false)
	private DeviceType deviceType;

	public Alert() {
	}

	public int getId() {
		return id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public List<AlertConfiguration> getAlertConfigurations() {
		return alertConfigurations;
	}
	
	public void setAlertConfigurations(List<AlertConfiguration> alertConfigurations) {
		this.alertConfigurations = alertConfigurations;
	}

	public boolean isRetired() {
		return retired;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", retired=" + retired + ", nameEn=" + nameEn + "]";
	}

}