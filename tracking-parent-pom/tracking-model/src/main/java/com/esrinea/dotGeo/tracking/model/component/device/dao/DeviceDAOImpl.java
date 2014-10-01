package com.esrinea.dotGeo.tracking.model.component.device.dao;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

public class DeviceDAOImpl extends AbstractDAO<Device> implements DeviceDAO {

	public DeviceDAOImpl() {
		super(Device.class);
	}
}
