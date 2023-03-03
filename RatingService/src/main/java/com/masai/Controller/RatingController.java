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

import com.masai.entity.Rating;
import com.masai.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingservice;
	
	@PostMapping
	public ResponseEntity<Rating>  createRating(@RequestBody Rating rating){
		Rating rating1=ratingservice.createrating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	@GetMapping
	public ResponseEntity<List<Rating>>  findAllrating(){
		List<Rating> rating=ratingservice.getAllRating();
		return ResponseEntity.status(HttpStatus.CREATED).body(rating);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>>  getRatingByUserId(@PathVariable    String userId){
		
		return ResponseEntity.ok(ratingservice.getRatingByUserId(userId));
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>>  getRatingByHotelId(@PathVariable String hotelId){
		
		return ResponseEntity.ok(ratingservice.getRatingByHotelId(hotelId));
	}

}
