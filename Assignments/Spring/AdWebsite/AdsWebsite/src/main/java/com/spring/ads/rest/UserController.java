package com.spring.ads.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.util.MemoryPeristance;

@RestController
public class UserController {
	
	private MemoryPeristance peristance;
	
	public UserController() {
		peristance = MemoryPeristance.getInstance();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User register(@RequestBody User user) {
		peristance.add(user);
		return user;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody User user) {
		return peristance.equals(user);
	}

	@RequestMapping(value = "/user/{userID}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable(value="userID") long userID, @RequestHeader(value="auth_token") String auth_token) {
		return peristance.get(userID, auth_token);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public boolean logout(@RequestHeader(value="auth_token") String auth_token) {
		return peristance.delete(auth_token);
	}
}
