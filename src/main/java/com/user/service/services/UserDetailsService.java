package com.user.service.services;

import com.user.service.dto.request.UserReq;
import com.user.service.entity.UserDetails;
import com.user.service.entity.UserMobile;
import com.user.service.entity.UserRole;
import com.user.service.exception.UserDetailsException;
import com.user.service.services.dto.response.UserResp;

public interface UserDetailsService {

	UserResp createUser(UserReq userReq) throws UserDetailsException;
	
	UserDetails getUser(Integer id) throws UserDetailsException;
	
	UserRole createUserRole(UserReq userReq) throws UserDetailsException;
	
	UserRole getUserRole(Integer roleId) throws UserDetailsException;
	
	UserMobile createUserMobile(UserReq userReq) throws UserDetailsException;
	
	UserMobile getUserMobile(String mobileNumber) throws UserDetailsException;
}
