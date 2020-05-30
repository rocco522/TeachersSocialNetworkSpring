package com.profesores.dao;

import com.profesores.model.TeacherSocialMedia;

public interface ISocialMediaDao {

	/**
	 * Find a TeacherSocialMedia relationship by idSocialMedia and nickname
	 * @param idSocialMedia The Social Media identifier
	 * @param nickname The TeacherSocialMedia relationship by nickname
	 * @return A TeacherSocialMedia object.
	 */
	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);
}
