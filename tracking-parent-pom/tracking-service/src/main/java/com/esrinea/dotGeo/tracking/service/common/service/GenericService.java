package com.esrinea.dotGeo.tracking.service.common.service;

public interface GenericService<T> {

	T find(int id);
	
	void create(T entity);
	
}
