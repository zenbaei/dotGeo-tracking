package com.esrinea.dotGeo.tracking.service.component.resource;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.resource.dao.ResourceDAO;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class ResourceServiceImpl extends AbstractService<Resource> implements ResourceService {

	private ResourceDAO resourceDAO;

	public ResourceServiceImpl(ResourceDAO resourceDAO) {
		super(resourceDAO);
		this.resourceDAO = resourceDAO;
	}
	
	@Override
	public List<Resource> find(boolean retired){
		return resourceDAO.find(retired);
	}

}
