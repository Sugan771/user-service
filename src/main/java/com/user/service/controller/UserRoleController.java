package com.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dto.request.UserReq;
import com.user.service.entity.UserRole;
import com.user.service.exception.UserDetailsException;
import com.user.service.servicesImpl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<UserRole> createNewUserRole(@RequestBody UserReq userReq) throws UserDetailsException{
		return ResponseEntity.ok(detailsServiceImpl.createUserRole(userReq));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserRole> getUserRole(@PathVariable Integer id) throws UserDetailsException{
		return ResponseEntity.ok(detailsServiceImpl.getUserRole(id));
	}
}
