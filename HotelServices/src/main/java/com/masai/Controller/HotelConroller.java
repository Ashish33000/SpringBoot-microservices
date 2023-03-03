package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Hotel;
import com.masai.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelConroller {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel>  createHotel(@RequestBody Hotel hotel){
		Hotel hotel1=hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel>  getSingelHotel(@PathVariable String hotelId){
		Hotel hotel=hotelService.getSingleHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel=hotelService.getAllHotel();
		return ResponseEntity.ok(hotel);
	}

}
