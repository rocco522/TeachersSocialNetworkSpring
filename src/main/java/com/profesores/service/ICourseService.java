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
}
