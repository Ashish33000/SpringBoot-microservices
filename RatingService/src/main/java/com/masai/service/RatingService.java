package com.masai.service;

import java.util.List;

import com.masai.entity.Rating;

public interface RatingService {
	public Rating createrating(Rating rating);
	public List<Rating> getAllRating();
	public List<Rating> getRatingByUserId(String userId);
	public List<Rating> getRatingByHotelId(String hotelId);
	
	

}
