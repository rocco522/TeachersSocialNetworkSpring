/**
 * 
 */
package com.profesores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rdelgado
 *
 */
@CrossOrigin
@RestController
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "Bienvenid@ <a href='http://platzy.com'>Mi sitio</a>";
		
		return response;
	}

}
