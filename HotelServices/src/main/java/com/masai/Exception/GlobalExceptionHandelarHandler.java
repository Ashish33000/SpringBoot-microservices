package com.masai.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandelarHandler {
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<ApiResponse> handlerUserException(HotelException ee){
	String message=ee.getMessage();
	ApiResponse response= ApiResponse.builder().message(message).sucess(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
}
