package com.user.service.servicesImpl;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.service.dto.request.UserReq;
import com.user.service.entity.UserDetils;
import com.user.service.entity.UserMobile;
import com.user.service.entity.UserRole;
import com.user.service.exception.UserDetailsException;
import com.user.service.services.UserDetailsService;
import com.user.service.services.dto.response.UserResp;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserResp createUser(UserReq userReq) throws UserDetailsException {
		try {
			
			if(Objects.nonNull(userReq)) {				
				UserDetils user = new UserDetils();
				user.setFirstNme(userReq.getFirstName());
				user.setMiddleName(userReq.getMiddleName());
				user.setLastName(userReq.getLastName());
				user.setEmailId(userReq.getEmailId());
				
				UserRole role = createUserRole(userReq);
				UserMobile mobile = updateUserMobile(userReq);
				
				
			}
		}catch (Exception e) {
			throw new UserDetailsException(e.getLocalizedMessage());
		}
		return null;
	}

	@Override
	public UserRole createUserRole(UserReq userReq) throws UserDetailsException {
		try {
			UserRole userRole = new UserRole();
			userRole.setRole(userReq.getUserRole());
		}catch (Exception e) {
			throw new UserDetailsException(e.getLocalizedMessage());
		}
		return null;
	}

	@Override
	public UserMobile updateUserMobile(UserReq userReq) throws UserDetailsException {
		try {

		} catch (Exception e) {
			throw new UserDetailsException(e.getLocalizedMessage());
		}
		return null;
	}

}
