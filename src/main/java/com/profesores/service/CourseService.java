/**
 * 
 */
package com.profesores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profesores.dao.ICourseDao;
import com.profesores.dao.ICrudDao;
import com.profesores.model.Course;

/**
 * @author rdelgado
 *
 */
@Service("courseService")
@Transactional
public class CourseService implements ICrudService<Course>, ICourseService{

	/**
	 * 
	 */
	public CourseService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private ICrudDao<Course> _crudDao;
	
	@Autowired
	private ICourseDao _courseDao;

	@Override
	public void insert(Course t) {
		_crudDao.insert(t);
		
	}

	@Override
	public void delete(Course t) {
		_crudDao.delete(t);
		
	}

	@Override
	public void deleteById(Long id) {
		_crudDao.deleteById(id);		
	}

	@Override
	public void update(Course t) {
		_crudDao.update(t);
	}

	@Override
	public List<Course> getAll() {
		return _crudDao.getAll();
	}

	@Override
	public Course findById(Long id) {
		return (Course) _crudDao.findById(id);
	}

	@Override
	public Course findByName(String name) {
		return (Course) _crudDao.findByName(name);
	}

	@Override
	public List<Course> findByIdteacher(Long idTeacher) {
		return _courseDao.findByIdteacher(idTeacher);
	}

}
