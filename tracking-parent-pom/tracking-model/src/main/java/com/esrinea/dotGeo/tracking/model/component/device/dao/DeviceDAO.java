package com.esrinea.dotGeo.tracking.model.component.device.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

public interface DeviceDAO extends GenericDAO<Device> {

	List<Device> findByIdNativeQuery(int id);

	Device find(int id, boolean retired);

	Device find(String serial, boolean retired);
}
