/**
 * 
 */
package com.profesores.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.profesores.model.Course;

/**
 * @author rdelgado
 *
 */
@Repository
@Transactional
public class CourseDao extends AbstractSession implements ICrudDao<Course>, ICourseDao{

	@Override
	public void insert(Course t) {
		getSession().persist(t);
		
	}

	@Override
	public void delete(Course t) {
		Course course = findById(t.getIdCourse());
		
		if(course != null)
			getSession().delete(course);
	}

	@Override
	public void update(Course t) {
		getSession().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAll() {
		return getSession().createQuery("from Course ").list();
	}

	@Override
	public Course findById(Long id) {
		return getSession().get(Course.class, id);
	}

	@Override
	public Course findByName(String name) {
		return (Course) getSession().createQuery("from Teacher where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public void deleteById(Long id) {
		Course temp = findById(id);
		
		if(temp != null)
			getSession().delete(temp);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findByIdteacher(Long idTeacher) {
		return (List<Course>) getSession().createQuery(
				"from Course c join c.teacher t where t.idTeacher = :idTeacher").setParameter("idTeacher", idTeacher);
	}

}
