package com.esrinea.dotGeo.tracking.service.component.device;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

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

	@Override
	public Device find(String serial, boolean retired) {
		return deviceDAO.find(serial, retired);
	}

	@Override
	public List<Device> find(boolean retired) {
		return deviceDAO.find(retired);
	}

	@Override
	public List<Device> findAndFetchDeviceType(boolean retired) {
		return deviceDAO.findAndFetchDeviceType(retired);
	}

}
