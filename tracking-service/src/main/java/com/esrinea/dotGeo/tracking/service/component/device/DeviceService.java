package com.esrinea.dotGeo.tracking.service.component.device;

import com.esrinea.dotGeo.tracking.model.component.employee.Employee;

public interface DeviceService {

	Employee getEmployee(long id);
	
	String getName();

}
