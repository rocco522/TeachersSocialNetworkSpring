package com.profesores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.profesores.model.Teacher;
import com.profesores.service.ITeacherService;
import com.profesores.util.ErrorMessage;

@RestController
@RequestMapping("/v1")
public class TeacherController {

	@Autowired
	ITeacherService _teacherService;
	
	@RequestMapping(value = "/teachers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getTeachers(){
		
		List<Teacher> teachers = _teacherService.getAll();
		
		if(teachers.isEmpty())
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("There is not teachers"), HttpStatus.NOT_FOUND);
		
		else {
			return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/teachers", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher){
		
		Teacher currenTeacher = _teacherService.findByName(teacher.getName());
		
		if( currenTeacher == null ) {
			if(teacher != null && !(teacher.getName().equals(null))) {
				_teacherService.insert(teacher);
				
				return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("Teacher already exist"), HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Name is requiered"), HttpStatus.FAILED_DEPENDENCY);
	}
	
}
