package com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

@Entity
@Table(name = "Tracking_Resource_ResGroup_Ass")
@NamedQueries(value = {
		@NamedQuery(name = "ResourceGroup.findByDeviceSerialRetired", query = "SELECT r FROM ResourceGroup r WHERE r.resource.device.serial = :deviceSerial AND r.retired = :retired AND r.resource.retired = :retired AND r.resource.device.retired = :retired"),
		@NamedQuery(name = "ResourceGroup.findByRetiredFence", query = "SELECT r FROM ResourceGroup r JOIN FETCH r.group WHERE r.group.fenceLayer IS NOT NULL"),
		@NamedQuery(name = "ResourceGroup.findByResourceIdRetired", query = "SELECT r FROM ResourceGroup r WHERE r.resource.id = :resourceId AND r.retired = :retired")

})
public class ResourceGroup implements Serializable {

	private static final long serialVersionUID = -5439973048725451099L;

	@Id
	@Column(name = "Track_Resource_ResGrp_DBID")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Resource_DBID")
	private Resource resource;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ResourceGroup_DBID")
	private Group group;

	@Column(name = "IsRetired")
	private boolean retired;

	public boolean isRetired() {
		return retired;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "ResourceGroup [id=" + id + ", retired=" + retired + "]";
	}

}
