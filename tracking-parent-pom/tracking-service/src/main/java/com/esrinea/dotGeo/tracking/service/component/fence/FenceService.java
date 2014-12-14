package com.esrinea.dotGeo.tracking.service.component.fence;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;

public interface FenceService extends GenericDAO<Fence>{
	
	List<Fence> find(int groupId, boolean retired);

}
