/**
 * 
 */
package com.profesores.dao;

import java.util.List;

import com.profesores.model.Course;

/**
 * @author rdelgado
 *
 */
public interface ICourseDao {

	List<Course> findByIdteacher(Long idTeacher);
}
