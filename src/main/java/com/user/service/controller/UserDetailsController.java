package com.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dto.request.UserReq;
import com.user.service.entity.UserDetails;
import com.user.service.exception.UserDetailsException;
import com.user.service.services.dto.response.UserResp;
import com.user.service.servicesImpl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<UserResp> createUser(@RequestBody UserReq userReq) throws UserDetailsException {
		UserResp user = detailsServiceImpl.createUser(userReq);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDetails> getUser(@PathVariable Integer id) throws UserDetailsException{
		return ResponseEntity.ok(detailsServiceImpl.getUser(id));
	}
}
