package com.spring.model;

public class Advertisement {

	private long postID;
	private long userID;
	private String title;
	private String category;
	private String description;
	private byte[] photo;

	public Advertisement() {
	}

	public Advertisement(long userID, String title, String category, String description) {
		super();
		this.userID = userID;
		this.title = title;
		this.category = category;
		this.description = description;
	}
	
	public long getPostID() {
		return postID;
	}

	public void setPostID(long postID) {
		this.postID = postID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
