/**
 * 
 */
package com.profesores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profesores.dao.ICrudDao;
import com.profesores.model.Teacher;

/**
 * @author rdelgado
 *
 */
@Service("teacherService")
@Transactional
public class TeacherService implements ICrudDao<Teacher>{

	@Autowired
	private ICrudDao<Teacher> _crudDao;
	
	/**
	 * 
	 */
	public TeacherService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Teacher t) {
		_crudDao.insert(t);
	}

	@Override
	public void delete(Teacher t) {
		_crudDao.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		_crudDao.deleteById(id);
	}

	@Override
	public void update(Teacher t) {
		_crudDao.update(t);
	}

	@Override
	public List<Teacher> getAll() {
		return _crudDao.getAll();
	}

	@Override
	public Teacher findById(Long id) {
		return _crudDao.findById(id);
	}

	@Override
	public Teacher findByName(String name) {
		return _crudDao.findByName(name);
	}

}
