package com.spring.aop.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

public class UserHandler {
	
	private List<User> users;
	private User currentUser;
	
	public UserHandler() {
		users = new ArrayList<User>();
		currentUser = null;
	}
	
	public void register(String username, String password, String firstname, String country) {
		System.out.println("register() called");
		users.add(new User(username, password, firstname, country));
	}

	public void login(String username, String password) {
		System.out.println("login() called");
		Optional<User> user = users.stream()
				.findAny().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
		
		if (user.isPresent()) {
			currentUser = user.get();
		}
	}

	public void logout() throws LoginException {
		System.out.println("logout() called");
		if (currentUser == null) {
			throw new LoginException("You need to login first!");
		}
		users.remove(currentUser);
	}
}
