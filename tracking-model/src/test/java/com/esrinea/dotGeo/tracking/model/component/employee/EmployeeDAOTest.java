package com.esrinea.dotGeo.tracking.model.component.employee;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-test-context.xml" })
@Transactional
public class EmployeeDAOTest {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Ignore
	public void testGetEmployee() {
		/*if(employeeDAO == null)
			Assert.fail("Employee DAO isn't injected");
		Employee emp = employeeDAO.getEmployee(100l);
		Assert.assertEquals("King", emp.getLastName());*/
	}

	public void setEmployeeDAO(EmployeeDAO employeDAO) {
		this.employeeDAO = employeDAO;
	}
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
}
