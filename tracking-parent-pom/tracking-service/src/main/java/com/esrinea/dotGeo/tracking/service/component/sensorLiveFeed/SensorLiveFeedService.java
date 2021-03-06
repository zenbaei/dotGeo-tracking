package com.esrinea.dotGeo.tracking.service.component.sensorLiveFeed;

import com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity.SensorLiveFeed;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface SensorLiveFeedService extends GenericService<SensorLiveFeed>{

	SensorLiveFeed find(String sensorValue);

}
