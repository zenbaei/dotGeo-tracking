package com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

public class SensorConfigurationDAOImpl extends AbstractDAO<SensorConfiguration> implements SensorConfigurationDAO {

	private static Logger LOG = Logger.getLogger(SensorConfigurationDAOImpl.class);

	public SensorConfigurationDAOImpl() {
		super(SensorConfiguration.class);
	}

	@Override
	public List<SensorConfiguration> find(int sensorId, boolean retired) {
		LOG.debug(String.format("SensorConfiguration.findBySensorIdRetired is called, parameters: %s, %s", sensorId, retired));
		List<SensorConfiguration> sensorConfigurations = entityManager
				.createNamedQuery("SensorConfiguration.findBySensorIdRetired", SensorConfiguration.class).setParameter("sensorId", sensorId)
				.setParameter("retired", retired).getResultList();

		if (sensorConfigurations.isEmpty()) {
			LOG.info(String.format("%s with ID %s has no %s sensor configurations.", "Sensor", sensorId, retired ? "retired" : "active"));
		}

		return sensorConfigurations;
	}
}
