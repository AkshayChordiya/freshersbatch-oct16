package com.spring.model;

public class Message {
	private String message;
	private int postID;

	public Message() {
	}

	public Message(String message, int postID) {
		super();
		this.message = message;
		this.postID = postID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

}
