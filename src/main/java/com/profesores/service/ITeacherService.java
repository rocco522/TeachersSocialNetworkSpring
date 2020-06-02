/**
 * 
 */
package com.profesores.service;

import java.util.List;

import com.profesores.model.Teacher;

/**
 * @author rdelgado
 *
 */
public interface ITeacherService {

void insert(Teacher t);
	
	void delete(Teacher t);
	
	void deleteById(Long id);
	
	void update(Teacher t);
	
	List<Teacher> getAll();
	
	Teacher findById(Long id);
	
	Teacher findByName(String name);
}
