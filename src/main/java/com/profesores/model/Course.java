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

@Entity
@Table(name = "Course")
public class Course implements Serializable{

	@Id
	@Column(name="id_course")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idCourse;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "themes")
	private String themes;
	
	@Column(name = "project")
	private String project;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;
	
	public Course() {
		super();
	}
	
	public Course(String name, String themes, String project) {
		this.name = name;
		this.themes = themes;
		this.project = project;
	}

	/**
	 * @return the idCourse
	 */
	public Long getIdCourse() {
		return idCourse;
	}

	/**
	 * @param idCourse the idCourse to set
	 */
	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
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
	 * @return the themes
	 */
	public String getThemes() {
		return themes;
	}

	/**
	 * @param themes the themes to set
	 */
	public void setThemes(String themes) {
		this.themes = themes;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
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
	
	
	
}
