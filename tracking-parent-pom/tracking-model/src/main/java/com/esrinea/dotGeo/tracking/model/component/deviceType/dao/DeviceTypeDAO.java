package com.esrinea.dotGeo.tracking.model.component.deviceType.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

public interface DeviceTypeDAO extends GenericDAO<DeviceType>{

	List<DeviceType> findAll(boolean retired);

}
