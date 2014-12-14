package com.esrinea.dotGeo.tracking.model.component.group.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;

public interface GroupDAO extends GenericDAO<Group>{

	List<Group> findByNotNullFenceLayer(boolean retired);
	Group findByNotNullFenceLayer(int id, boolean retired);
}
