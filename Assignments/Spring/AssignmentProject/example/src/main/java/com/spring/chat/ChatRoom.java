package com.spring.chat;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {

	private String chatRoomName;
	private Set<String> messages;
	private Set<User> users;

	public ChatRoom() {
	}

	public ChatRoom(String chatRoomName) {
		super();
		this.chatRoomName = chatRoomName;
		messages = new HashSet<>();
		users = new HashSet<>();
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	public Set<String> getMessages() {
		return messages;
	}

	public void setMessages(Set<String> messages) {
		this.messages = messages;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "ChatRoom [" + chatRoomName + "]";
	}

}
