package com.esrinea.dotGeo.tracking.service.component.device;

import org.springframework.stereotype.Service;

import com.esrinea.dotGeo.tracking.model.component.employee.Employee;
import com.esrinea.dotGeo.tracking.model.component.employee.EmployeeDAO;

@Service
public class DeviceServiceImpl implements DeviceService {

	private EmployeeDAO employeeDAO;

	@Override
	public Employee getEmployee(long id) {
		return employeeDAO.getEmployee(id);
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public String getName() {
		return "islam zenbaei";
	}

}
