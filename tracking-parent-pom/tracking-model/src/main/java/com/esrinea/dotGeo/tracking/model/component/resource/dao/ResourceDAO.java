package com.esrinea.dotGeo.tracking.model.component.resource.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

public interface ResourceDAO extends GenericDAO<Resource> {
	
	List<Resource> find(boolean retired); 
	
}
