package com.kelver.services.interfaces;

import java.util.List;

public interface CrudService<T, K> {
	
	List<T> all();
	T byId(K id);
	T insert(T entity);
	T update(T entity);
	void delete(T entity);
	void deleteById(K id);

}
