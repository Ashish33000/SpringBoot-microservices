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

import com.masai.entity.User;
import com.masai.service.Userservice;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private Userservice userservice;
	@PostMapping
	public ResponseEntity<User>  createuser(@RequestBody User user){
		User user1=userservice.saveuser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User>  getSingleUser(@PathVariable String userId){
		User user=userservice.getUser(userId);
		return ResponseEntity.ok(user);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user=userservice.getAlluser();
		return ResponseEntity.ok(user);
	}

}
