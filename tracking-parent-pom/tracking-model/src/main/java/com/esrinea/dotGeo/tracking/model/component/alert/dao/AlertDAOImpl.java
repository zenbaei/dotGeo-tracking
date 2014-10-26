package com.esrinea.dotGeo.tracking.model.component.alert.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;

public class AlertDAOImpl extends AbstractDAO<Alert> implements AlertDAO {

	private static Logger LOG = Logger.getLogger(AlertDAOImpl.class);

	public AlertDAOImpl() {
		super(Alert.class);
	}

	@Override
	public List<Alert> find(int deviceTypeId, boolean retired) {
		List<Alert> alerts = entityManager.createNamedQuery("Alert.findByDeviceTypeRetired", Alert.class).setParameter("deviceTypeId", deviceTypeId)
				.setParameter("retired", retired).getResultList();

		if (alerts.isEmpty()) {
			LOG.info(String.format("%s with ID %s has no %s alerts.", "Device Type", deviceTypeId, retired ? "retired" : "active"));
		}
		return alerts;
	}

}
