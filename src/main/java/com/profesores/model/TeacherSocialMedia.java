/**
 * 
 */
package com.profesores.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rdelgado
 *
 */
@Entity
@Table(name = "Teacher_Social_Media")
public class TeacherSocialMedia implements Serializable{
	
	@Id
	@Column(name = "id_teacher_social_media")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTeacherSocialMedia;

	@Column(name = "nickname")
	private String nickname;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_social_media")
	private SocialMedia socialMedia;
	

	/**
	 * 
	 */
	public TeacherSocialMedia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idTeacherSocialMedia
	 * @param idTeacher
	 * @param idSocialMedia
	 * @param nickname
	 */
	public TeacherSocialMedia(Teacher teacher, SocialMedia socialMedia, String nickname) {
		super();
		this.teacher = teacher;
		this.socialMedia = socialMedia;
		this.nickname = nickname;
	}

	/**
	 * @return the idTeacherSocialMedia
	 */
	public Long getIdTeacherSocialMedia() {
		return idTeacherSocialMedia;
	}

	/**
	 * @param idTeacherSocialMedia the idTeacherSocialMedia to set
	 */
	public void setIdTeacherSocialMedia(Long idTeacherSocialMedia) {
		this.idTeacherSocialMedia = idTeacherSocialMedia;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the socialMedia
	 */
	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	/**
	 * @param socialMedia the socialMedia to set
	 */
	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

	}
