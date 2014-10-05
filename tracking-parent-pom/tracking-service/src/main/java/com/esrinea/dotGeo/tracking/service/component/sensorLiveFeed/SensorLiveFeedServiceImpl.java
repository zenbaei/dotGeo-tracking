package com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed;

import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.dao.SensorLiveFeedDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;
import com.esrinea.dotGeo.tracking.service.common.AbstractService;

public class SensorLiveFeedServiceImpl extends AbstractService<SensorLiveFeed> implements SensorLiveFeedService {

	private SensorLiveFeedDAO sensorLiveFeedDAO;
	
	public SensorLiveFeedServiceImpl(SensorLiveFeedDAO sensorLiveFeedDAO) {
		super(sensorLiveFeedDAO);
		this.sensorLiveFeedDAO = sensorLiveFeedDAO;
	}

}
