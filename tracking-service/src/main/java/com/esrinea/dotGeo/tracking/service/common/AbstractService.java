package com.esrinea.dotGeo.tracking.service.common;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;

public abstract class AbstractService<T> implements GenericService<T> {
	
	private AbstractDAO<T> abstractDAO;	
	
	@Override
	public T find(int id) {
		return abstractDAO.find(id);
	}

}
