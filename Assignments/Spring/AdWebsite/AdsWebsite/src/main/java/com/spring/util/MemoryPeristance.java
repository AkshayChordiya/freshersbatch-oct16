package com.spring.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.model.Advertisement;
import com.spring.model.User;

public class MemoryPeristance implements Persistance {

	private static MemoryPeristance sMemoryPeristance;
	private int currentUserID;
	private int currentPostID;
	private List<User> userHolder;
	private List<Advertisement> advertisements;
	private Map<Long, String> authTokens;

	private MemoryPeristance() {
		userHolder = new ArrayList<>();
		advertisements = new ArrayList<>();
		authTokens = new HashMap<>();
		currentUserID = 0;
		currentPostID = 0;
	}

	public static MemoryPeristance getInstance() {
		if (sMemoryPeristance == null) {
			sMemoryPeristance = new MemoryPeristance();
		}
		return sMemoryPeristance;
	}

	private long getNextUserID() {
		return currentUserID++;
	}
	
	public long getNextPostID() {
		return currentPostID++;
	}

	@Override
	public void add(User user) {
		user.setId(getNextUserID());
		userHolder.add(user);
	}
	
	public User get(String auth_token) {
		Optional<Long> optUserID = authTokens.entrySet().stream()
				.findAny()
				.filter(e -> e.getValue().equals(auth_token))
				.map(e -> e.getKey());
		if (optUserID.isPresent()) {
			return get(optUserID.get(), auth_token);
		}
		return null;
	}
	
	@Override
	public User get(Long userID, String auth_token) {
		if (authTokens.containsKey(userID) && authTokens.containsValue(auth_token)) { 
			Optional<User> optUser = userHolder.stream().findAny().filter(u -> u.getId() == userID);
			if (optUser.isPresent()) {
				return optUser.get();
			}
		}
		return null;
	}
	
	@Override
	public boolean delete(String authToken) {
		return authTokens.entrySet().removeIf(e -> e.getValue().equals(authToken));
		/*Optional<Long> optUserID = authTokens.entrySet().stream()
				.findAny()
				.filter(e -> e.getValue().equals(authToken))
				.map(e -> e.getKey());
		if (optUserID.isPresent()) {
			Long userID = optUserID.get();
			authTokens.remove(userID);
			userHolder.removeIf(u -> u.getId() == userID);
		}*/
	}
	
	/*public String getAuthToken(Long userID) {
		return authTokens.get(userID);
	}
	
	public boolean equals(String authToken) {
		return authTokens.containsValue(authToken);
	}*/

	@Override
	public boolean equals(User user) {
		authTokens.put(user.getId(), "aws");
		return userHolder.stream().anyMatch(u -> u.equals(user));
	}

	@Override
	public Advertisement get(String authToken, long postID) {
		User user = get(authToken);
		Optional<Advertisement> optAd = advertisements.stream().findAny().filter(ad -> ad.getPostID() == postID && ad.getUserID() == user.getId());
		if (optAd.isPresent()) {
			return optAd.get();
		}
		return null;
	}
	
	@Override
	public boolean delete(String authToken, long postID) {
		User user = get(authToken);
		if (user != null) {
			return advertisements.removeIf(ad -> ad.getPostID() == postID);
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userHolder;
	}
	
	@Override
	public List<Advertisement> getAllAdvertisements() {
		return advertisements;
	}

	@Override
	public void add(Advertisement ad) {
		advertisements.add(ad);
	}

	@Override
	public void update(Advertisement old, Advertisement newAd) {
		int index = advertisements.indexOf(old);
		advertisements.set(index, newAd);
	}


}

