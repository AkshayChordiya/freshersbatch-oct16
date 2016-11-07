package com.hibernate.chat;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CHATROOM")
public class ChatRoom {
	
	@Id
	@GeneratedValue
	@Column(name="room_id")
	private Long chatRoomId;
	
	@Column(name="name")
	private String chatRoomName;
	
	@OneToMany(mappedBy="chatroom", cascade={CascadeType.ALL})
	private Set<Message> messages;
	
	@OneToMany(mappedBy="chatroom", cascade={CascadeType.ALL})
	private Set<User> users;
	
	//private int currentLoggedUser;
	
	public ChatRoom() {
	}
	
	public ChatRoom(String chatRoomName) {
		super();
		this.chatRoomName = chatRoomName;
		messages = new HashSet<>();
		users = new HashSet<>();
	}

	public Long getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(Long chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
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
		return "ChatRoom [chatRoomId=" + chatRoomId + ", chatRoomName=" + chatRoomName + "]";
	}
	
	/*public void addUser(User user) {
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
	}*/
	
}
