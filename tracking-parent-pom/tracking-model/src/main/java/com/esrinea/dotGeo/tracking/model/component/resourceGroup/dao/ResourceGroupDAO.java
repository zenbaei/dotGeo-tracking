package com.esrinea.dotGeo.tracking.model.component.resourceGroup.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;

public interface ResourceGroupDAO extends GenericDAO<ResourceGroup> {

	List<ResourceGroup> find(boolean retired, boolean hasFence);

	List<ResourceGroup> find(String deviceSerial, boolean retired);
	
	List<ResourceGroup> find(int resourceId, boolean retired);
}
