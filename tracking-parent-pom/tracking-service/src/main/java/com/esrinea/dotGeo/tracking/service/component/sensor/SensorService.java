package com.esrinea.dotGeo.tracking.service.component.sensor;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.service.common.GenericService;

public interface SensorService extends GenericService<Sensor> {

	List<Sensor> find(int deviceTypeId, boolean retired);

}
