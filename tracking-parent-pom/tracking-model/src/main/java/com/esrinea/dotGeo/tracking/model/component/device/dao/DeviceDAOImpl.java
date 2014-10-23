package com.esrinea.dotGeo.tracking.model.component.device.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

public class DeviceDAOImpl extends AbstractDAO<Device> implements DeviceDAO {

	private static Logger LOG = Logger.getLogger(DeviceDAOImpl.class);

	public DeviceDAOImpl() {
		super(Device.class);
	}

	@Override
	public List<Device> findByIdNativeQuery(int id) {
		return entityManager.createNamedQuery("Device.findById", Device.class).setParameter(1, id).getResultList();
	}

	@Override
	public Device find(int id, boolean retired) {
		Device device = null;
		try{
			device = entityManager.createNamedQuery("Device.findByIdRetired", Device.class).setParameter("id", id).setParameter("retired", retired)
					.getSingleResult();
		} catch (NoResultException ex) {
			String errMsg = String.format("%s with ID %s does not exist in database or is not %s.", "Device", id, retired ? "retired" : "active");
			LOG.info(errMsg);
			throw new NoResultException(errMsg);
		}
		return device;
	}
}
