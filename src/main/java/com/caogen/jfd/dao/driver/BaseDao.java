package com.caogen.jfd.dao.driver;

import java.util.List;

/**
 * CRUD
 * 
 * @author Spuiln
 *
 * @param <T>
 */
public interface BaseDao<T> {

	void insert(T entity);

	void delete(T entity);

	void update(T entity);

	T get(T entity);

	List<T> find(T entity);
}
