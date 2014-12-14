package com.esrinea.dotGeo.tracking.service.component.group;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface GroupService extends GenericService<Group> {

	List<Group> findByNotNullFenceLayer(boolean retired);
	
	Group findByNotNullFenceLayer(int id, boolean retired);

}
