package com.esrinea.dotGeo.tracking.model.component.group.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;
import com.esrinea.dotGeo.tracking.model.component.fenceLayer.entity.FenceLayer;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;

@Entity
@Table(name = "Tracking_Resource_Groups")
@NamedQueries({
@NamedQuery(name = "Group.findByRetiredFenceLayer", query = "SELECT g FROM Group g WHERE g.fenceLayer IS NOT NULL AND g.retired = :retired"),
@NamedQuery(name = "Group.findByIdRetiredFenceLayer", query = "SELECT g FROM Group g WHERE g.id = :id AND g.retired = :retired AND g.fenceLayer IS NOT NULL"),
})
public class Group implements Serializable {

	private static final long serialVersionUID = -8602400489141748091L;

	@Id
	@Column(name = "ResourceGroup_DBID")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FenceLayer_DBID")
	private FenceLayer fenceLayer;

	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<Fence> fences;

	@Column(name = "IsRetired")
	private boolean retired;
	
	@Column(name="Description_En")
	private String descEn;
	
	public int getId() {
		return id;
	}

	public boolean isRetired() {
		return retired;
	}

	public FenceLayer getFenceLayer() {
		return fenceLayer;
	}

	public List<Fence> getFences() {
		return fences;
	}
	
	public void setFences(List<Fence> fences) {
		this.fences = fences;
	}
	
	public String getDescEn() {
		return descEn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", fenceLayer=" + fenceLayer + ", fences=" + fences + ", retired=" + retired + "]";
	}

}
