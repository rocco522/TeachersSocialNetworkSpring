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
public class TeacherService implements ITeacherService{
	
	@Autowired
	private ICrudDao<Teacher> _crudService;

	@Override
	public void insert(Teacher t) {
		_crudService.insert(t);
		
	}

	@Override
	public void delete(Teacher t) {
		_crudService.delete(t);		
	}

	@Override
	public void deleteById(Long id) {
		_crudService.deleteById(id);
	}

	@Override
	public void update(Teacher t) {
		_crudService.update(t);
	}

	@Override
	public List<Teacher> getAll() {
		return _crudService.getAll();
	}

	@Override
	public Teacher findById(Long id) {
		return _crudService.findById(id);
	}

	@Override
	public Teacher findByName(String name) {
		return _crudService.findByName(name);
	}
	
	

}
