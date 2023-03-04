package com.masai.service;

import java.util.List;

import com.masai.entity.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Hotel getSingleHotel(String hotelId);

}
