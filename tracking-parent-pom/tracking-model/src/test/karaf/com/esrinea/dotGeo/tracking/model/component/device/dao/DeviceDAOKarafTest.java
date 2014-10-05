package com.esrinea.dotGeo.tracking.model.component.device.dao;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

public class DeviceDAOKarafTest {

	private DeviceDAO deviceDAO;
	private static Logger LOG = Logger.getLogger(DeviceDAOKarafTest.class);

	public void test() {
		if (deviceDAO == null) {
			LOG.error("Entity Manager has not been injected");
			return;
		}

		Device device = deviceDAO.find(1);
		if (device == null) {
			LOG.info("Device with ID: 1, hasn't been retrieved, make sure record exists.");
			return;
		}
		
		LOG.info("Device with ID: 1, has been retieved successfully.");
	}
	
	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}
}
