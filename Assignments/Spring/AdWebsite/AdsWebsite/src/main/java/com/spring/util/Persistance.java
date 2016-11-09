package com.spring.util;

import java.util.List;

import com.spring.model.Advertisement;
import com.spring.model.User;

public interface Persistance {
	
	void add(User user);
	void add(Advertisement user);
	Advertisement get(String authToken, long postID);
	void update(Advertisement old, Advertisement newAd);
	
	User get(Long userID, String authToken);
	boolean delete(String authToken);
	boolean delete(String authToken, long postID);
	
	List<User> getAllUsers();
	List<Advertisement> getAllAdvertisements();
	
	boolean equals(User user);
}
