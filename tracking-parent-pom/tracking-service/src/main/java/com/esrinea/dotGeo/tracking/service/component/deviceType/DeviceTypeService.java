package com.esrinea.dotGeo.tracking.service.component.deviceType;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.service.common.GenericService;

public interface DeviceTypeService extends GenericService<DeviceType> {

	List<DeviceType> findAll(boolean retired);


}
