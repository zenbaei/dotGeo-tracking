package com.esrinea.dotGeo.tracking.model.component.employee;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.employee.Employee;
import com.esrinea.dotGeo.tracking.model.component.employee.EmployeeDAO;

public class EmployeeDAOKarafTest {

	private EmployeeDAO  employeeDAO;
	private Logger log = Logger.getLogger(getClass());

	public void test() {
		Employee emp = employeeDAO.getEmployee(100l);
		log.info("employee: " + emp.getLastName() + " has been retrieved successfully");
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
