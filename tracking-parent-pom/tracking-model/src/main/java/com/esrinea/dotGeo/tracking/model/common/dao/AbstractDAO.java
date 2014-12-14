package com.esrinea.dotGeo.tracking.model.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.eclipse.persistence.internal.sessions.AbstractRecord.NoEntry;

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
		if (entity == null) {
			String errMsg = String.format("No Entity was found for type %s and ID of %s.", entityClass.getSimpleName(), id);
			LOG.info(errMsg);
			throw new EntityNotFoundException(errMsg);
		}
		LOG.debug("Entity " + entity.getClass().getSimpleName() + " with ID = " + id + " has been looked up.");
		LOG.trace("Looked up entity details: " + entity);
		return entity;
	}

	@Override
	public void create(T entity) {
		try {
			entityManager.persist(entity);
			LOG.debug("Entity " + entity.getClass().getSimpleName() + " has been created.");
			LOG.trace("Created entity details: " + entity);
		} catch (Exception e) {
			LOG.error(e); //the exception is swallowed on karaf
			throw e;
		}
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
