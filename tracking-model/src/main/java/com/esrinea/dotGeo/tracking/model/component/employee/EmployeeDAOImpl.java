package com.esrinea.dotGeo.tracking.model.component.employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee getEmployee(long id) {
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
