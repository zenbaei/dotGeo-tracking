package com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;

public interface ResourceLiveFeedDAO extends GenericDAO<ResourceLiveFeed> {

	List<ResourceLiveFeed> find(Device Device);

}
