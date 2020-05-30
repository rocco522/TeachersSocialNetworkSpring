/**
 * 
 */
package com.profesores.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.profesores.model.TeacherSocialMedia;

/**
 * @author rdelgado
 *
 */
@Repository
@Transactional
public class TeacherSocialMediaDao extends AbstractSession implements ICrudDao<TeacherSocialMedia> {

	@Override
	public void insert(TeacherSocialMedia t) {
		getSession().persist(t);
	}

	@Override
	public void delete(TeacherSocialMedia t) {
		TeacherSocialMedia temp = findById(t.getIdTeacherSocialMedia());

		if (temp != null)
			getSession().delete(temp);

	}

	@Override
	public void deleteById(Long id) {
		TeacherSocialMedia temp = findById(id);

		if (temp != null)
			getSession().delete(temp);

	}

	@Override
	public void update(TeacherSocialMedia t) {
		getSession().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherSocialMedia> getAll() {
		return getSession().createQuery("from TeacherSocialMedia").list();
	}

	@Override
	public TeacherSocialMedia findById(Long id) {
		return getSession().get(TeacherSocialMedia.class, id);
	}

	@Override
	public TeacherSocialMedia findByName(String name) {
		return (TeacherSocialMedia) getSession().createQuery("from TeacherSocialMedia where nickname = :nickname")
				.setParameter("nickname", name).uniqueResult();
	}

}
