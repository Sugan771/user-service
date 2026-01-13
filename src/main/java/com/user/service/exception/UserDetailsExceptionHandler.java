package com.user.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserDetailsExceptionHandler {

	@ExceptionHandler(UserDetailsException.class)
	public ResponseEntity<ErrorResponse> exception(UserDetailsException exception){
		return ResponseEntity.status(exception.getError().getHttpStatus()).body(exception.getError());
	}
}
