package com.youtube.com.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
	
	public RestResponse saveOrUpdate(@RequestBody String userJson) 
			throws JsonParseException, JsonMappingException, IOException {
	
		User user = this.mapper.readValue(userJson, User.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		this.userService.save(user);
		
		return new RestResponse(HttpStatus.values(),"Operacion exitosa");
	}
	
	private boolean validate(User user) {
		
		boolean isValid = true;

		if(user.getFirstName() == null) {
			isValid = false;
		}
		
		if(user.getFirstSurname() == null) {
			isValid = false;
		}
		
		if(user.getAddress() == null) {
			isValid = false;
		}
		
		return isValid;
	}
	
}
