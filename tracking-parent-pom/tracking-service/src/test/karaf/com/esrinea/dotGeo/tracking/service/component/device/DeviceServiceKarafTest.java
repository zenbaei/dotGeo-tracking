package com.esrinea.dotGeo.tracking.service.component.device;

import org.apache.log4j.Logger;

public class DeviceServiceKarafTest {

	private DeviceService deviceService;
	private Logger log = Logger.getLogger(getClass());

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public void test() {
		if (deviceService != null)
			log.info("Device Service has been initialized successfully.");
		else
			log.error("Device Service initialization failed.");
	}

}
