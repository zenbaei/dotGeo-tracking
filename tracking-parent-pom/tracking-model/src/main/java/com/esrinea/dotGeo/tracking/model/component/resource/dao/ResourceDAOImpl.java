package com.esrinea.dotGeo.tracking.model.component.resource.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
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

	@Override
	public Resource find(int deviceId, boolean retired) {
		LOG.debug(String.format("Resource.findByDeviceIdRetired, parameters: %s, %s", deviceId, retired));
		Resource resource = null;
		try {
			resource = entityManager.createNamedQuery("Resource.findByDeviceIdRetired", Resource.class).setParameter("deviceId", deviceId).setParameter("retired", retired).getSingleResult();
		} catch (NoResultException ex) {
		LOG.warn(String.format("%s with Device ID %s does not exist in database or is %s.", "Resource", deviceId, retired ? "not retired" : "retired"));
		} catch (NonUniqueResultException ex) {
			LOG.warn(String.format("%s for Device ID of %s is duplicated or the one to one realtion it is joining with is refering it, more than once by mistake.", "Resource", deviceId));
		}
		return resource;
	}

}
