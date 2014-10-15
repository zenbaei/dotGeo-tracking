package com.esrinea.dotGeo.tracking.model.component.sensor.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

public interface SensorDAO extends GenericDAO<Sensor> {

	List<Sensor> find(int deviceTypeId, boolean retired);

}
