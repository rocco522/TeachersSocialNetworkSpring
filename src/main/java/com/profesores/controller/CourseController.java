package com.profesores.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.profesores.model.Course;
import com.profesores.service.ICourseService;
import com.profesores.util.ErrorMessage;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class CourseController {
	
	@Autowired
	ICourseService _courseService;

	@RequestMapping(value = "/courses", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getCourses(@RequestParam(value = "name", required = false) String name){
		
		if(name == null || name.equals("")) {
			List<Course> courses = _courseService.getAll();
			
			if(courses.isEmpty())
				return new ResponseEntity<ErrorMessage>(new ErrorMessage("Courses is empty"), HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
		}
		
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Not found"), HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/courses", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCourse(@RequestBody Course course){
		
		if(course == null || course.getName().equals(null) || course.getProject().equals(null) || course.getThemes().equals(null)) {
			return new ResponseEntity<ErrorMessage>(new ErrorMessage(), HttpStatus.BAD_REQUEST);
		} else {
			Course currentCourse = _courseService.findByName(course.getName());
			
			if(currentCourse != null && currentCourse.getName().equals(course.getName())) {
				return new ResponseEntity<ErrorMessage>(new ErrorMessage("Course already exist"), HttpStatus.NO_CONTENT);
			}
			
			_courseService.insert(course);
			
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Long idCourse){
		Course currentCourse = _courseService.findById(idCourse);
		if(currentCourse == null)
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("Course not found"), HttpStatus.NOT_FOUND);
		
		_courseService.delete(currentCourse);
		
		return new ResponseEntity<String>("{\"message\":\"done\"}", HttpStatus.OK);
	}

}
