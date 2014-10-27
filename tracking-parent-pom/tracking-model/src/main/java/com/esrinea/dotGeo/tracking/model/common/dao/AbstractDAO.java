package com.esrinea.dotGeo.tracking.model.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;
	private Class<T> entityClass;
	private static Logger LOG = Logger.getLogger(AbstractDAO.class);
	
	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T find(int id) {
		T entity = entityManager.find(entityClass, id);
		LOG.debug("Entity " + entity.getClass().getSimpleName() + " with ID = " + id + " has been looked up.");
		LOG.trace("Looked up entity details: " + entity);
		return entity;
	}
	
	@Override
	public void create(T entity) {
		entityManager.persist(entity);		
		LOG.debug("Entity " + entity.getClass().getSimpleName() + " has been created.");
		LOG.trace("Created entity details: " + entity);
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
