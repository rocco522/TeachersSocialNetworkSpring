/**
 * 
 */
package com.profesores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profesores.dao.ICrudDao;
import com.profesores.dao.ISocialMediaDao;
import com.profesores.model.SocialMedia;
import com.profesores.model.TeacherSocialMedia;

/**
 * @author rdelgado
 *
 */
@Service("socialMediaService")
@Transactional
public class SocialMediaService implements ICrudDao<SocialMedia>, ISocialMediaService{

	@Autowired
	private ICrudDao<SocialMedia> _crudDao;
	
	@Autowired
	private ISocialMediaDao _socialMediaDao;
	
	/**
	 * 
	 */
	public SocialMediaService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		return _socialMediaDao.findSocialMediaByIdAndName(idSocialMedia, nickname);
	}

	@Override
	public void insert(SocialMedia t) {
		_crudDao.insert(t);		
	}

	@Override
	public void delete(SocialMedia t) {
		_crudDao.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		_crudDao.deleteById(id);
	}

	@Override
	public void update(SocialMedia t) {
		_crudDao.update(t);
	}

	@Override
	public List<SocialMedia> getAll() {
		return _crudDao.getAll();
	}

	@Override
	public SocialMedia findById(Long id) {
		return _crudDao.findById(id);
	}

	@Override
	public SocialMedia findByName(String name) {
		return _crudDao.findByName(name);
	}

}
