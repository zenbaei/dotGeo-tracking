package com.esrinea.dotGeo.tracking.service.component.resourceGroup;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.resourceGroup.dao.ResourceGroupDAO;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class ResourceGroupServiceImpl extends AbstractService<ResourceGroup> implements ResourceGroupService {

	private ResourceGroupDAO resourceGroupDAO;

	public ResourceGroupServiceImpl(ResourceGroupDAO resourceGroupDAO) {
		super(resourceGroupDAO);
		this.resourceGroupDAO = resourceGroupDAO;
	}

	@Override
	public List<ResourceGroup> find(int resourceId, boolean retired) {
		return resourceGroupDAO.find(resourceId, retired);
	}

}
