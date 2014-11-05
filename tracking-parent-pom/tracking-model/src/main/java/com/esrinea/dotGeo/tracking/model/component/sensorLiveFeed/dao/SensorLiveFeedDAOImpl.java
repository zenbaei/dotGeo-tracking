package com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.dao;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;

public class SensorLiveFeedDAOImpl extends AbstractDAO<SensorLiveFeed> implements SensorLiveFeedDAO {

	private static Logger LOG = Logger.getLogger(SensorLiveFeedDAOImpl.class);

	public SensorLiveFeedDAOImpl() {
		super(SensorLiveFeed.class);
	}

	@Override
	public SensorLiveFeed find(String sensorValue) {
		LOG.debug("findBySensorValue: " + sensorValue);
		return entityManager.createNamedQuery("SensorLiveFeed.findBySensorValue", SensorLiveFeed.class).setParameter("sensorValue", sensorValue).getSingleResult();
	}

}
