package com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.dao;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;

public class SensorLiveFeedDAOImpl extends AbstractDAO<SensorLiveFeed>
		implements SensorLiveFeedDAO {

	public SensorLiveFeedDAOImpl() {
		super(SensorLiveFeed.class);
	}

	@Override
	public SensorLiveFeed find(String sensorValue) {
		return entityManager.createNamedQuery("SensorLiveFeed.findBySensorValue", SensorLiveFeed.class).setParameter("sensorValue", sensorValue).getSingleResult();
	}

}
