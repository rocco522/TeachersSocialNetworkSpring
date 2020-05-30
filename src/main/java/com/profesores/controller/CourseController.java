package com.profesores.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.profesores.model.Course;
import com.profesores.service.ICourseService;
import com.profesores.util.ErrorMessage;

@Controller
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

}
