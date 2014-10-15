package com.esrinea.dotGeo.tracking.service.component.alertLiveFeed;

import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.dao.AlertLiveFeedDAO;
import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity.AlertLiveFeed;
import com.esrinea.dotGeo.tracking.service.common.AbstractService;

public class AlertLiveFeedServiceImpl extends AbstractService<AlertLiveFeed> implements AlertLiveFeedService {

	private AlertLiveFeedDAO alertLiveFeedDAO;
	
	public AlertLiveFeedServiceImpl(AlertLiveFeedDAO alertLiveFeedDAO) {
		super(alertLiveFeedDAO);
		this.alertLiveFeedDAO = alertLiveFeedDAO;
	}
	
	

}
