package com.esrinea.dotGeo.tracking.service.test;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.employee.Employee;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;

public class DeviceServiceTest {
	
	private DeviceService deviceService;
	private Logger log = Logger.getLogger(getClass());
	
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	public void test(){
		Employee emp = deviceService.getEmployee(200l);
		log.info("Employee: " + emp.getLastName() +" has been retrived succefully");
	}

}
