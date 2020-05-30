/**
 * 
 */
package com.profesores.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.profesores.model.Teacher;
import com.profesores.model.TeacherSocialMedia;

/**
 * @author rdelgado
 *
 */
@Repository
@Transactional
public class TeacherDao extends AbstractSession implements ICrudDao<Teacher>{

	
	@Override
	public void insert(Teacher t) {
		getSession().persist(t);
		
	}

	@Override
	public void delete(Teacher t) {
		Teacher teacher = findById(t.getIdTeacher());
		
		if(teacher != null)
			getSession().delete(teacher);
	}

	@Override
	public void update(Teacher t) {
		getSession().update(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAll() {
		return getSession().createQuery("from Teacher").list();
	}

	@Override
	public Teacher findById(Long id) {
		return getSession().get(Teacher.class, id);
	}

	@Override
	public Teacher findByName(String name) {
		return (Teacher) getSession().createQuery("from Teacher where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public void deleteById(Long id) {
		Teacher teacher = findById(id);
		
		if(teacher != null) {
			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedia().iterator();
			
			while(i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(teacher);
		}
		
	}

}
