package com.esrinea.dotGeo.tracking.model.component.fence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;

@Entity
@Table(name = "Tracking_ResGroup_Fences_Ass")
@NamedQuery(name = "Fence.findByGroupIdRetired", query = "SELECT f FROM Fence f WHERE f.group.id = :groupId AND f.retired = :retired")
public class Fence implements Serializable {

	private static final long serialVersionUID = 4576118350287970411L;

	@Id
	@Column(name = "ResourceGroup_FenceLayer_DBID")
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ResourceGroup_DBID")
	private Group group;

	@Column(name = "GeoFenceRule")
	private String rule;

	@Column(name = "IsRetired")
	private boolean retired;

	public boolean isRetired() {
		return retired;
	}

	@Override
	public String toString() {
		return "Fence [id=" + id + ", rule=" + rule + ", retired=" + retired + "]";
	}

}
