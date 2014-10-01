package com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;

public class ResourceLiveFeedDAOImpl extends AbstractDAO<ResourceLiveFeed>
		implements ResourceLiveFeedDAO {

	private static Logger LOG = Logger.getLogger(ResourceLiveFeedDAOImpl.class);

	public ResourceLiveFeedDAOImpl() {
		super(ResourceLiveFeed.class);
	}

	@Override
	public List<ResourceLiveFeed> find(Device device) {
		return super.entityManager
				.createNamedQuery("ResourceLiveFeed.findByDevice",
						ResourceLiveFeed.class)
				.setParameter("deviceId", device.getId()).getResultList();
	}

}
