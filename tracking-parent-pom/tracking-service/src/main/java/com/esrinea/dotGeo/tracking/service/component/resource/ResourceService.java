package com.esrinea.dotGeo.tracking.service.component.resource;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface ResourceService extends GenericService<Resource> {

	List<Resource> find(boolean retired);

}
