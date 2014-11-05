package com.esrinea.dotGeo.tracking.service.component.alertSensorLiveFeed;

import com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.dao.AlertSensorLiveFeedDAO;
import com.esrinea.dotGeo.tracking.model.component.alertSensorLiveFeed.entity.AlertSensorLiveFeed;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class AlertSensorLiveFeedServiceImpl extends AbstractService<AlertSensorLiveFeed> implements AlertSensorLiveFeedService {

	public AlertSensorLiveFeedServiceImpl(AlertSensorLiveFeedDAO alertSensorLiveFeedDAO) {
		super(alertSensorLiveFeedDAO);
	}

}
