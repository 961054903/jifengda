package com.caogen.jfd.service;

/**
 * 
 * @author Spuiln
 *
 * @param <T>
 */
public interface BaseService<T> {

	void create(T entity);

	void remove(T entity);

	void modify(T entity);

	T getById(Integer id);

}
