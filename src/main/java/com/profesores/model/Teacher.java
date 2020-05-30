package com.profesores.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable{

	@Id
	@Column(name = "id_teacher")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTeacher;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "avatar")
	private String avatar;
	
	@OneToMany(mappedBy = "teacher")
	private Set<Course> courses;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_teacher")
	private Set<TeacherSocialMedia> teacherSocialMedia;
	
	/**
	 * 
	 */
	public Teacher() {
		super();
	}

	/**
	 * @param name
	 * @param avatar
	 */
	public Teacher(String name, String avatar) {
		super();
		this.name = name;
		this.avatar = avatar;
	}

	/**
	 * @return the idTeacher
	 */
	public Long getIdTeacher() {
		return idTeacher;
	}

	/**
	 * @param idTeacher the idTeacher to set
	 */
	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the teacherSocialMedia
	 */
	public Set<TeacherSocialMedia> getTeacherSocialMedia() {
		return teacherSocialMedia;
	}

	/**
	 * @param teacherSocialMedia the teacherSocialMedia to set
	 */
	public void setTeacherSocialMedia(Set<TeacherSocialMedia> teacherSocialMedia) {
		this.teacherSocialMedia = teacherSocialMedia;
	}

	/**
	 * @return the courses
	 */
	public Set<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
}
