package com.esrinea.dotGeo.tracking.model.component.deviceType.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

public class DeviceTypeDAOImpl extends AbstractDAO<DeviceType> implements DeviceTypeDAO {

	private static Logger LOG = Logger.getLogger(DeviceTypeDAOImpl.class);

	public DeviceTypeDAOImpl() {
		super(DeviceType.class);
	}

	@Override
	public List<DeviceType> find(boolean retired) {
		List<DeviceType> deviceTypes = entityManager.createNamedQuery("DeviceType.findByRetired", DeviceType.class).setParameter("retired", retired).getResultList();

		if (deviceTypes.isEmpty()) {
			LOG.info(String.format("No %s with retired status of %s has been found.", "Device Types", retired));
		}

		return deviceTypes;

	}

	@Override
	public DeviceType find(int id, boolean retired) {
		LOG.debug(String.format("Device.findByIdRetired, parameters: %s, %s", id, retired));
		DeviceType deviceType = null;
		try {
			deviceType = entityManager.createNamedQuery("DeviceType.findByIdRetired", DeviceType.class).setParameter("id", id).setParameter("retired", retired).getSingleResult();
		} catch (NoResultException nre) {
			throw new NoResultException(String.format("%s with criteria of ID is %s, RETIRED is %s does not exist in DB.", "DeviceType", id, retired));
		} catch (NonUniqueResultException nur) {
			throw new NonUniqueResultException(String.format("%s with criteria of ID is %s, RETIRED is %s is duplicated or the one to one realtion it is joining with is refering it, more than once by mistake.", "DeviceType", id, retired));
		}
		return deviceType;
	}

}
