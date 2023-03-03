package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.Exception.UserException;
import com.masai.entity.Rating;
import com.masai.entity.User;
import com.masai.repository.UserRepoaitory;
@Service
public class UserServiceImpl implements Userservice {
	@Autowired
   private UserRepoaitory userRepo;
	

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(Userservice.class);
	
	
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
		User user=userRepo.findById(userId).orElseThrow(()->new UserException("User not found: "+userId)); 
		//fetch rating of the above user from rating service
		//http://localhost:8087/ratings/users/6155e81f-7000-49b3-a0fb-019e93ca99f0
	   ArrayList<Rating> ratingofUser=restTemplate.getForObject("http://localhost:8087/ratings/users/6155e81f-7000-49b3-a0fb-019e93ca99f0", ArrayList.class);
		logger.info("{} ",ratingofUser);
		user.setRatings(ratingofUser);
		return user;
	}

}
