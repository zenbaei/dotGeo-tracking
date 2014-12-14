package com.esrinea.dotGeo.tracking.model.component.fenceLayer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tracking_Fence_Layers")
public class FenceLayer implements Serializable {

	private static final long serialVersionUID = -37127609685984531L;

	@Id
	@Column(name = "FenceLayer_DBID")
	private int id;
	
	@Column(name="Layer_URL")
	private String url;
	
	public String getURL() {
		return url;
	}

	@Override
	public String toString() {
		return "FenceLayer [id=" + id + ", url=" + url + "]";
	}
	
	

}
