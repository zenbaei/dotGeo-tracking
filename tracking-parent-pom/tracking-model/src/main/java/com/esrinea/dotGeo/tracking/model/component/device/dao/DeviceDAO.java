package com.esrinea.dotGeo.tracking.model.component.device.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

public interface DeviceDAO extends GenericDAO<Device> {

	List<Device> findByIdQuery(int id);
	
	public Device findByIdCriteria(int id) ;
}
