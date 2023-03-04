package com.masai.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.Exception.UserException;
import com.masai.entity.Hotel;
import com.masai.entity.Rating;
import com.masai.entity.User;
import com.masai.external.services.HotelService;
import com.masai.repository.UserRepoaitory;
@Service
public class UserServiceImpl implements Userservice {
	@Autowired
   private UserRepoaitory userRepo;
	

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
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
	   Rating[] ratingofUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		//logger.info("{}",ratingofUser);
		List<Rating> ratings=Arrays.stream(ratingofUser).toList();
		
		List<Rating> ratingList=ratings.stream().map(rating->{
			//http://localhost:8089/hotels/869f507b-7a86-4715-b75a-dcf7e7a820f4
		//ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		Hotel hotel=hotelService.getHotel(rating.getHotelId());
		//logger.info("response statux code: {}",forEntity.getStatusCode());
		
			rating.setHotel(hotel);
			
			return rating;
			
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

}
