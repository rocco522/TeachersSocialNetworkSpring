package com.profesores.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.function.ServerRequest.Headers;
import org.springframework.web.util.UriComponentsBuilder;
import com.profesores.service.ICrudService;
import com.profesores.service.ISocialMediaService;
import com.profesores.util.ErrorMessage;
import com.profesores.model.SocialMedia;

@Controller
@RequestMapping("/v1")
public class SocialMediaController{
	
	@Autowired
	ISocialMediaService _socialMediaService;
	
	
	//GET
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/socialMedias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getSocialMedias(@RequestParam(value = "name", required = false) String name){
		
		if(name == null || name.equals("")) {
			List<SocialMedia> socialMedias = new ArrayList<>();
			socialMedias = (List<SocialMedia>) _socialMediaService.getAll();
			
			if(socialMedias.isEmpty()) {
				return new ResponseEntity<List<SocialMedia>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<SocialMedia>>(socialMedias, HttpStatus.OK);
		} else {
			SocialMedia socialMedia = _socialMediaService.findByName(name);
			if(socialMedia != null) {
				return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Not found."), HttpStatus.NOT_FOUND);	
		
	}
	
	//GET
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getSocialMediaById(@PathVariable("id") Long idSocialMedia){
		
		if(idSocialMedia == null || idSocialMedia <= 0 || !(idSocialMedia instanceof Long)) 
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("idSocialMedia is not valid"), HttpStatus.CONFLICT);
			
		SocialMedia socialMedia = _socialMediaService.findById(idSocialMedia);
		
		if(socialMedia == null)
			return new ResponseEntity<SocialMedia>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
	}

	//POST
	@RequestMapping(value = "/socialMedias", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia socialMedia, UriComponentsBuilder uriComponentsBuilder){
		
		if(socialMedia.getName().equals(null) || socialMedia.getName().isEmpty()) {
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("IdSocialMedia is required."), HttpStatus.NO_CONTENT);
		}
		
		if(_socialMediaService.findByName(socialMedia.getName()) != null ) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		_socialMediaService.insert((SocialMedia) socialMedia);
		HttpHeaders headers = new HttpHeaders();
		SocialMedia sm =  _socialMediaService.findByName(socialMedia.getName());
		headers.setLocation(uriComponentsBuilder.path("/v1/socialMedias/{id}").buildAndExpand(sm.getIdSocialMedia()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//UPDATE
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> updateSocialMedia(@PathVariable("id") Long idSocialMedia, @RequestBody SocialMedia socialMedia){
		
		SocialMedia currentSocialMedia = _socialMediaService.findById(idSocialMedia);
		
		if(currentSocialMedia == null) 
			return new ResponseEntity<SocialMedia>(HttpStatus.NO_CONTENT); 
		
		if(!(socialMedia.getName().equals(null)) && !(socialMedia.getName().equals("")))
			currentSocialMedia.setName(socialMedia.getName());
		
		if(!(socialMedia.getIcon().equals(null)) && !(socialMedia.getIcon().equals("")))
			currentSocialMedia.setIcon(socialMedia.getIcon());
		
		return new ResponseEntity<SocialMedia>(currentSocialMedia, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteSocialMedias(@PathVariable("id") Long idSocialMedia){
		
		SocialMedia currenSocialMedia = _socialMediaService.findById(idSocialMedia);
		
		if(currenSocialMedia == null)
			return new ResponseEntity<ErrorMessage>(new ErrorMessage("SocialMedia not found"), HttpStatus.NOT_FOUND);
		
		_socialMediaService.delete(currenSocialMedia);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}