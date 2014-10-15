package com.esrinea.dotGeo.tracking.service.component.device;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.service.common.AbstractService;

public class DeviceServiceImpl extends AbstractService<Device> implements DeviceService {

	private DeviceDAO deviceDAO;

	public DeviceServiceImpl(DeviceDAO deviceDAO) {
		super(deviceDAO);
		this.deviceDAO = deviceDAO;
	}

	@Override
	public Device find(int id, boolean retired) {
		return deviceDAO.find(id, retired);
	}

}
