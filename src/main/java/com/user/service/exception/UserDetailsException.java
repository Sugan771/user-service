package com.user.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserDetailsException extends Exception {

	public UserDetailsException(String errorMsg) {
		super(errorMsg);
		error.setErrorMsg(errorMsg);
		error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public UserDetailsException(String errorMsg, HttpStatus httpStatus) {
		super(errorMsg);
		error.setErrorMsg(errorMsg);
		error.setHttpStatus(httpStatus);
	}
	
	private ErrorResponse error;

}
