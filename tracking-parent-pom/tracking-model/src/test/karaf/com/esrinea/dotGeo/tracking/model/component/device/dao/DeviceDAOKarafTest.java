package com.esrinea.dotGeo.tracking.model.component.device.dao;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

public class DeviceDAOKarafTest {

	private DeviceDAO deviceDAO;
	private static Logger LOG = Logger.getLogger(DeviceDAOKarafTest.class);
	private int id;

	public void test() {
		Device device = null;
		
		if (deviceDAO == null) {
			LOG.error("Entity Manager has not been injected");
			return;
		}

		try {
			device = deviceDAO.find(id);
		} catch (EntityNotFoundException e) {
			//if not catched bundle deployment will fail
		}

		if (device == null) {
			LOG.warn(String.format("Device with ID: %s, hasn't been retrieved, make sure record exists.", id));
			return;
		}

		LOG.info(String.format("Device with ID: %s, has been retieved successfully.", id));
	}

	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
