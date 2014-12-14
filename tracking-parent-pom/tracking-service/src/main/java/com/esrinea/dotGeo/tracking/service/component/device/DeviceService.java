package com.esrinea.dotGeo.tracking.service.component.device;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface DeviceService extends GenericService<Device> {

	Device find(int id, boolean retired);

	Device find(String serial, boolean retired);
	
	List<Device> find(boolean retired);

}
