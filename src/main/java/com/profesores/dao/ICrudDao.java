/**
 * 
 */
package com.profesores.dao;

import java.util.List;

/**
 * @author rdelgado
 * @param <T>
 *
 */
public interface ICrudDao<T> {

	void insert(T t);
	
	void delete(T t);
	
	void deleteById(Long id);
	
	void update(T t);
	
	List<T> getAll();
	
	T findById(Long id);
	
	T findByName(String name);
}
