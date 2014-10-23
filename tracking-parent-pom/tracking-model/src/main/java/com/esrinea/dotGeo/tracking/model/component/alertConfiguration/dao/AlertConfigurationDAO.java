package com.esrinea.dotGeo.tracking.model.component.alertConfiguration.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;

public interface AlertConfigurationDAO extends GenericDAO<AlertConfiguration>{
	
	public List<AlertConfiguration> find(int alertId, boolean retired);

	public AlertConfiguration findBySensorConfiguration(int sensorConfigurationId);

}
