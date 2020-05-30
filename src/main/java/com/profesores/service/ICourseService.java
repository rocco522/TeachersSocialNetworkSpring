/**
 * 
 */
package com.profesores.service;

import java.util.List;

import com.profesores.model.Course;

/**
 * @author rdelgado
 *
 */
public interface ICourseService {
	List<Course> findByIdteacher(Long idTeacher);
	
void insert(Course course);
	
	void delete(Course course);
	
	void deleteById(Long id);
	
	void update(Course course);
	
	List<Course> getAll();
	
	Course findById(Long id);
	
	Course findByName(String name);
}
