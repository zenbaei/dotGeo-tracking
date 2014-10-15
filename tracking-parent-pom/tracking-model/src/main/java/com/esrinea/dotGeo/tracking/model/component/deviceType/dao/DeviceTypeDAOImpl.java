package com.esrinea.dotGeo.tracking.model.component.deviceType.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

public class DeviceTypeDAOImpl extends AbstractDAO<DeviceType> implements DeviceTypeDAO {

	private static Logger LOG = Logger.getLogger(DeviceTypeDAOImpl.class);
	
	public DeviceTypeDAOImpl() {
		super(DeviceType.class);
	}

	@Override
	public List<DeviceType> findAll(boolean retired) {
		List<DeviceType> deviceTypes = entityManager.createNamedQuery("DeviceType.findByRetired", DeviceType.class).setParameter("retired", retired)
				.getResultList();

		if (deviceTypes.isEmpty()) {
			LOG.info(String.format("No %s with status of %s exists.", "Device Types", retired ? "retired" : "active"));
		}
		
		return deviceTypes;

	}

}
