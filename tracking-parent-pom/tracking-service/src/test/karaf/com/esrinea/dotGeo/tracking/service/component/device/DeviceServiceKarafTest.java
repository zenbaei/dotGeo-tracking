package com.esrinea.dotGeo.tracking.service.component.device;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.service.component.deviceType.DeviceTypeService;

public class DeviceServiceKarafTest {

	private DeviceService deviceService;
	private Logger log = Logger.getLogger(getClass());
	private DeviceTypeService deviceTypeService;

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public void setDeviceTypeService(DeviceTypeService deviceTypeService) {
		this.deviceTypeService = deviceTypeService;
	}

	public void test() {
		if (deviceService != null)
			log.info("Device Service has been initialized successfully.");
		else
			log.error("Device Service initialization failed.");

		if (deviceTypeService == null) {
			log.error("Device Service initialization failed.");
		} else {
			log.info("Calling DeviceTypeService.findAll(false)");
			List<DeviceType> deviceTypes = deviceTypeService.find(false);
			if (deviceTypes == null || deviceTypes.isEmpty()) {
				log.info("No result found after calling deviceTypeService.findAll.");
			} else {
				log.info("Records were found after deviceTypeService.findAll.");
			}
		}
	}
}
