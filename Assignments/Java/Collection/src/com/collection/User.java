package com.collection;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User> {
	private String name;
	private String password;
	private List<String> messages;
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		messages = new ArrayList<>();
	}
	
	public User(String name) {
		super();
		this.name = name;
		messages = new ArrayList<>();
	}

	public void addMessage(String message) {
		messages.add(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "User: " + name + " (" + password + ")";
	}

	@Override
	public int compareTo(User o) {
		return this.name.compareTo(o.name);
	}
	
}