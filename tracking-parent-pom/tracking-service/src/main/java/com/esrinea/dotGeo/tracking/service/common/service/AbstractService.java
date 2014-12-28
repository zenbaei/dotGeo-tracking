package com.esrinea.dotGeo.tracking.service.common.service;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;

public abstract class AbstractService<T> implements GenericService<T> {
	
	private GenericDAO<T> genericDAO;
	
	public AbstractService(GenericDAO<T> genericDAO) {
		this.genericDAO = genericDAO;
	}
	
	@Override
	public T find(int id) {
		return genericDAO.find(id);
	}
	
	@Override
	public void create(T entity) throws Exception {
		genericDAO.create(entity);
	}

}
