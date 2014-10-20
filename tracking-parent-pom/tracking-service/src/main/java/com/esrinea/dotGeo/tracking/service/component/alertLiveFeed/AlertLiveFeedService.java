package com.esrinea.dotGeo.tracking.service.component.alertLiveFeed;

import com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity.AlertLiveFeed;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface AlertLiveFeedService extends GenericService<AlertLiveFeed> {

	AlertLiveFeed findByAlert(int alertId);


}
