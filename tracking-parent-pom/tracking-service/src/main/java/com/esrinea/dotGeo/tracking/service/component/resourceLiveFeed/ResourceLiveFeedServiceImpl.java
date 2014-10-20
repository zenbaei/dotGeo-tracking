package com.esrinea.dotGeo.tracking.service.component.resourceLiveFeed;

import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.dao.ResourceLiveFeedDAO;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class ResourceLiveFeedServiceImpl extends AbstractService<ResourceLiveFeed> implements ResourceLiveFeedService {

	private ResourceLiveFeedDAO resourceLiveFeedDAO;
	
	public ResourceLiveFeedServiceImpl(ResourceLiveFeedDAO resourceLiveFeedDAO) {
		super(resourceLiveFeedDAO);
		this.resourceLiveFeedDAO = resourceLiveFeedDAO;
	}
	
	

}
