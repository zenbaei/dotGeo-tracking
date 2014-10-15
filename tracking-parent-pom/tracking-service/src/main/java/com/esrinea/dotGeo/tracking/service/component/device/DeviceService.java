package com.esrinea.dotGeo.tracking.service.component.device;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.service.common.GenericService;

public interface DeviceService extends GenericService<Device> {

	Device find(int id, boolean retired);

}
