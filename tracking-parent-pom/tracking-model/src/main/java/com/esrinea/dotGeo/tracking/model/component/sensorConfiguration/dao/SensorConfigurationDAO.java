package com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

public interface SensorConfigurationDAO extends GenericDAO<SensorConfiguration>{

	List<SensorConfiguration> find(int sensorId, boolean retired);

}
