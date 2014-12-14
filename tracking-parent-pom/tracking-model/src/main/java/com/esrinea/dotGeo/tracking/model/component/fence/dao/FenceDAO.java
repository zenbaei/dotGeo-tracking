package com.esrinea.dotGeo.tracking.model.component.fence.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;

public interface FenceDAO extends GenericDAO<Fence>{

	List<Fence> find(int groupId, boolean retired);

}
