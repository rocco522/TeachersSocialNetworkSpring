package com.profesores.service;

import java.util.List;

import com.profesores.model.SocialMedia;
import com.profesores.model.TeacherSocialMedia;

public interface ISocialMediaService {
	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);
	
	void insert(SocialMedia t);

	void delete(SocialMedia t);

	void deleteById(Long id);

	void update(SocialMedia t);

	List<SocialMedia> getAll();

	SocialMedia findById(Long id);

	SocialMedia findByName(String name);
	
}
