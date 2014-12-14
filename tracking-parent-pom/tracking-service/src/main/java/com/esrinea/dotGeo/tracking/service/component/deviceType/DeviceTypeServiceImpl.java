package com.esrinea.dotGeo.tracking.service.component.deviceType;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.deviceType.dao.DeviceTypeDAO;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class DeviceTypeServiceImpl extends AbstractService<DeviceType> implements DeviceTypeService {

	private DeviceTypeDAO deviceTypeDAO;
	
	public DeviceTypeServiceImpl(DeviceTypeDAO deviceTypeDAO) {
		super(deviceTypeDAO);
		this.deviceTypeDAO = deviceTypeDAO;
	}
	
	@Override
	public List<DeviceType> find(boolean retired) {
		return deviceTypeDAO.find(retired);
	}

}
