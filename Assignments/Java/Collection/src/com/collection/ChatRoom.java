package com.collection;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
	
	private String chatRoomName;
	private List<String> messages;
	private List<User> users;
	
	private int currentLoggedUser;
	
	public ChatRoom(String chatRoomName) {
		super();
		this.chatRoomName = chatRoomName;
		messages = new ArrayList<>();
		users = new ArrayList<>();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void sendMessage(String message) {
		message = users.get(currentLoggedUser) + ": " + message;
		messages.add(message);
		users.get(currentLoggedUser).addMessage(message);
	}
	
	public User login(User user) {
		currentLoggedUser = users.indexOf(user);
		return users.get(currentLoggedUser);
	}
	
	public List<String> getMessages() {
		return messages;
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void logout() {
		currentLoggedUser = 0;
	}

	public void remove(User user) {
		users.remove(user);
	}
	
}
