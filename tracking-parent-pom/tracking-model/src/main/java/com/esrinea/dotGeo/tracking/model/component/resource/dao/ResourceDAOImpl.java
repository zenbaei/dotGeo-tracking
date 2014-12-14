package com.esrinea.dotGeo.tracking.model.component.resource.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

public class ResourceDAOImpl extends AbstractDAO<Resource> implements ResourceDAO {

	private static final Logger LOG = Logger.getLogger(ResourceDAOImpl.class);

	public ResourceDAOImpl() {
		super(Resource.class);
	}

	@Override
	public List<Resource> find(boolean retired) {
		LOG.debug(String.format("Resource.findByRetired, parameters are: %s.", retired));
		List<Resource> resources = entityManager.createNamedQuery("Resource.findByRetired", Resource.class).setParameter("retired", retired).getResultList();
		if (resources == null) {
			LOG.info(String.format("No Records were found in Tracking_Resources table with criteria of RETIRED is %s.", retired));
			return null;
		}
		return resources;
	}

}
