package com.esrinea.dotGeo.tracking.model.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;
	private Class<T> entityClass;
	
	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T find(int id) {
		return entityManager.find(entityClass, id);
	}
	
	@Override
	public void create(T entity) {
		entityManager.persist(entity);		
	}

}
