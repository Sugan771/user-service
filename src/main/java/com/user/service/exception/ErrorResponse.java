package com.user.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String errorMsg;
	
	private HttpStatus httpStatus;
}
