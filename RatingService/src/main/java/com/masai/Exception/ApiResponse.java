package com.masai.Exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	
	private String message;
	private boolean sucess;
	private HttpStatus status;

}
