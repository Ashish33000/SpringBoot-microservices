package com.masai.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.HotelException;
import com.masai.entity.Hotel;
import com.masai.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getSingleHotel(String id) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(id).orElseThrow(()->new HotelException("Hotel not found with id: "+id));
	}

}
