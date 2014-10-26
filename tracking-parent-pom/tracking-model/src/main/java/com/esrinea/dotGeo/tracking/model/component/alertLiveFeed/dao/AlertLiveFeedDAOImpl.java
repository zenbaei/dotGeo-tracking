package com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.dao;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity.AlertLiveFeed;

public class AlertLiveFeedDAOImpl extends AbstractDAO<AlertLiveFeed> implements AlertLiveFeedDAO {

	public AlertLiveFeedDAOImpl() {
		super(AlertLiveFeed.class);
	}

	@Override
	public AlertLiveFeed findByAlert(int alertId) {
		return entityManager.createNamedQuery("AlertLiveFeed.findByAlert", AlertLiveFeed.class).setParameter("alertId", alertId).getSingleResult();
	}
	

}
