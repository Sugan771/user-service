package com.user.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserDetailsException extends Exception {

	public UserDetailsException(String errorMsg) {
		super(errorMsg);
		this.error = new ErrorResponse(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public UserDetailsException(String errorMsg, HttpStatus httpStatus) {
		super(errorMsg);
		this.error = new ErrorResponse(errorMsg, httpStatus);
	}
	
	private final ErrorResponse error;

}
