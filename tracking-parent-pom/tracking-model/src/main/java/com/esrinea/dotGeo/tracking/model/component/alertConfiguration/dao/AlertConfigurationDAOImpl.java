package com.esrinea.dotGeo.tracking.model.component.alertConfiguration.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;

public class AlertConfigurationDAOImpl extends AbstractDAO<AlertConfiguration> implements AlertConfigurationDAO {

	protected static Logger LOG = Logger.getLogger(AlertConfigurationDAOImpl.class);
	
	public AlertConfigurationDAOImpl() {
		super(AlertConfiguration.class);
	}

	@Override
	public List<AlertConfiguration> find(int alertId, boolean retired) {
		List<AlertConfiguration> alertConfigurations = entityManager
				.createNamedQuery("AlertConfiguration.findByAlertRetired", AlertConfiguration.class).setParameter("alertId", alertId)
				.setParameter("retired", retired).getResultList();

		if (alertConfigurations.isEmpty()) {
			LOG.info(String.format("%s with ID %s has no %s alert configurations.", "Alert", alertId, retired ? "retired" : "active"));
		}

		return alertConfigurations;

	}

	@Override
	public AlertConfiguration findBySensorConfiguration(int sensorConfigurationId) {
		return entityManager.createNamedQuery("AlertConfiguration.findBySensorConfiguration", AlertConfiguration.class).setParameter("sensorConfigurationId", sensorConfigurationId).getSingleResult();
	}

}
