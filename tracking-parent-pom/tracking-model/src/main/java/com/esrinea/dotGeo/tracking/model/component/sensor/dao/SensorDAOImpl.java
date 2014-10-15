package com.esrinea.dotGeo.tracking.model.component.sensor.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

public class SensorDAOImpl extends AbstractDAO<Sensor> implements SensorDAO {

	private static Logger LOG = Logger.getLogger(SensorDAOImpl.class);

	public SensorDAOImpl() {
		super(Sensor.class);
	}

	@Override
	public List<Sensor> find(int deviceTypeId, boolean retired) {
		List<Sensor> sensors = entityManager.createNamedQuery("Sensor.findByDeviceTypeRetired", Sensor.class).setParameter("id", deviceTypeId)
				.setParameter("retired", retired).getResultList();

		if (sensors.isEmpty()) {
			LOG.info(String.format("%s with ID %s has no %s sensors.", "Device Type", deviceTypeId, retired ? "retired" : "active"));
		}

		return sensors;
	}

}
