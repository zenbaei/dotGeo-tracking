package com.esrinea.dotGeo.tracking.service.component.alertConfiguration;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface AlertConfigurationService extends GenericService<AlertConfiguration>{

	List<AlertConfiguration> find(int alertId, boolean retired);

	AlertConfiguration findBySensorConfiguration(int sensorConfigurationId);

}
