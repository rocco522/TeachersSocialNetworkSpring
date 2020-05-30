/**
 * 
 */
package com.profesores.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.profesores.model.SocialMedia;
import com.profesores.model.TeacherSocialMedia;

/**
 * @author rdelgado
 *
 */
@Repository
@Transactional
public class SocialMediaDao extends AbstractSession implements ICrudDao<SocialMedia>, ISocialMediaDao {

	@Override
	public void insert(SocialMedia t) {
		getSession().persist(t);		
	}

	@Override
	public void delete(SocialMedia t) {
		SocialMedia temp = findById(t.getIdSocialMedia());
		
		if(temp != null)
			getSession().delete(temp);
		
	}

	@Override
	public void update(SocialMedia t) {
		getSession().update(t);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialMedia> getAll() {
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findById(Long id) {
		return (SocialMedia) getSession().get(SocialMedia.class, id);
	}

	@Override
	public SocialMedia findByName(String name) {
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public void deleteById(Long id) {
		SocialMedia temp = findById(id);
		
		if(temp != null)
			getSession().delete(temp);
		
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		@SuppressWarnings("unchecked")
		List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join.socialMedia sm "
				+ "where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname").setParameter("idSocialMedia", idSocialMedia)
				.setParameter("nickname", nickname).list();
		
		if(objects.size() > 0) {
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if(object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}
		
		return null;
	}

}
