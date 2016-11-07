package com.hibernate.chat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Id
	@GeneratedValue
	@Column(name="message_id")
	private Long messageId;
	
	@Column(name="message")
	private String message;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id")
	private ChatRoom chatroom;
	
	public Message() {
	}

	public Message(String message, ChatRoom chatRoom) {
		super();
		this.message = message;
		this.chatroom = chatRoom;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ChatRoom getChatRoom() {
		return chatroom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatroom = chatRoom;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + "]";
	}
	
}
