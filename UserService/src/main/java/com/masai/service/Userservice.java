package com.masai.service;

import com.masai.entity.User;

import java.util.List;
public interface Userservice {
	
	public User saveuser(User user);
	public List<User> getAlluser();
	public User getUser(String userId);

}
