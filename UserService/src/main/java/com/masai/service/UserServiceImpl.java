package com.masai.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.entity.User;
import com.masai.repository.UserRepoaitory;
@Service
public class UserServiceImpl implements Userservice {
	@Autowired
   private UserRepoaitory userRepo;
	@Override
	public User saveuser(User user) {
		// TODO Auto-generated method stub
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAlluser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		 
		return userRepo.findById(userId).orElseThrow(()->new UserException("User not found: "+userId));
	}

}
