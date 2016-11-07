package com.hibernate.chat.persist;

import com.hibernate.chat.User;

public interface Persistance {
	// Create
	void createChatRoom(String chatRoomName);
	boolean createUser(String chatRoomName, String username, String password);
	
	// Play methods
	User login(String chatRoomName, String username, String password);
	void sendMessage(String chatRoomName, String message);
	
	
	// Read
	void showAllMessages(String chatRoomName);
	void showAllUsers(String chatRoomName);
	
	// Delete
	boolean deleteChatRoom(String chatRoomName);
	boolean deleteUser(String username);
	
	void close();
}