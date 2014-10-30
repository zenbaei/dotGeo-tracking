package com.esrinea.dotGeo.tracking.model.component.device.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

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
		LOG.debug(String.format("Device.findByIdRetired, parameters: %s, %s", id, retired));
		Device device = null;
		try {
			device = entityManager.createNamedQuery("Device.findByIdRetired", Device.class).setParameter("id", id).setParameter("retired", retired).getSingleResult();
		} catch (NoResultException ex) {
			String errMsg = String.format("%s with ID %s does not exist in database or is %s.", "Device", id, retired ? "not retired" : "retired");
			LOG.info(errMsg);
			throw new NoResultException(errMsg);
		}
		return device;
	}

	@Override
	public Device find(String serial, boolean retired) {
		LOG.debug(String.format("Device.findBySerialRetired, parameters: %s, %s", serial, retired));
		Device device = null;
		try {
			device = entityManager.createNamedQuery("Device.findBySerialRetired", Device.class).setParameter("serial", serial.trim()).setParameter("retired", retired).getSingleResult();
		} catch (NoResultException ex) {
			String errMsg = String.format("%s with Serial %s does not exist in database or is %s.", "Device", serial, retired ? "not retired" : "retired");
			LOG.info(errMsg);
			throw new NoResultException(errMsg);
		} catch (NonUniqueResultException ex) {
			LOG.error(String.format("Device with Serial %s is duplicated or the one to one realtion it is joining with is refering it more than once by mistake.", device.getSerial()));
			throw ex;
		}
		return device;
	}

}
