package com.esrinea.dotGeo.tracking.model.common.dao;

public interface GenericDAO<T> {
	
	T find(int id);
	
	void create(T entity) throws Exception;

}
