package com.spring.ads.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Advertisement;
import com.spring.model.Message;
import com.spring.model.User;
import com.spring.util.MemoryPeristance;

@RestController
public class PostController {
	
private MemoryPeristance peristance;
	
	public PostController() {
		peristance = MemoryPeristance.getInstance();
	}
	
	@RequestMapping(value = "/postAd", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Advertisement postAdvertise(@RequestBody Advertisement advertisement, @RequestHeader(value="auth_token") String auth_token) {
		User user = peristance.get(auth_token);
		if (user != null) {
			advertisement.setPostID(peristance.getNextPostID());
			peristance.add(advertisement);
			return advertisement;
		}
		return null;
	}
	
	@RequestMapping(value = "/postAd/{postID}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateAdvertise(@PathVariable(value="postID") long postID, 
									@RequestBody Advertisement advertisement, 
									@RequestHeader(value="auth_token") String auth_token) {
		Advertisement oldAd = peristance.get(auth_token, postID);
		if (oldAd != null) {
			peristance.update(oldAd, advertisement);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Message sendMessage(@RequestBody Message mesage, @RequestHeader(value="auth_token") String auth_token) {
		User user = peristance.get(auth_token);
		if (user != null) {
			return mesage;
		}
		return null;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public List<Advertisement> getAllAdvertisements(@RequestHeader(value="auth_token") String auth_token) {
		return peristance.getAllAdvertisements();
	}
	
	@RequestMapping(value = "/post/{postID}", method = RequestMethod.GET)
	public Advertisement getAdvertisement(@PathVariable(value="postID") long postID, @RequestHeader(value="auth_token") String auth_token) {
		return peristance.get(auth_token, postID);
	}
	
	@RequestMapping(value = "/post/{postID}", method = RequestMethod.DELETE)
	public boolean deleteAdvertisement(@PathVariable(value="postID") long postID, @RequestHeader(value="auth_token") String auth_token) {
		return peristance.delete(auth_token, postID);
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<String> getAllCategories() {
		return peristance.getAllAdvertisements().stream().map(ad -> ad.getCategory()).distinct().collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/posts/search/{searchText}", method = RequestMethod.GET)
	public List<Advertisement> getFilteredAdvertisements(@PathVariable(value="searchText") String searchText) {
		return peristance.getAllAdvertisements().stream()
				.filter(ad -> ad.getTitle().contains(searchText) || ad.getDescription().contains(searchText)
						|| ad.getCategory().contains(searchText))
				.collect(Collectors.toList());
	}

}
