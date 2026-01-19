package com.user.service.servicesImpl;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.service.dto.request.UserReq;
import com.user.service.entity.UserDetails;
import com.user.service.entity.UserMobile;
import com.user.service.entity.UserRole;
import com.user.service.exception.UserDetailsException;
import com.user.service.repo.UserDetailsRepository;
import com.user.service.repo.UserMobileRepository;
import com.user.service.repo.UserRoleRepository;
import com.user.service.services.UserDetailsService;
import com.user.service.services.dto.response.UserResp;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private UserMobileRepository userMobileRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserResp createUser(UserReq userReq) throws UserDetailsException {
		try {
			
			if(Objects.nonNull(userReq)) {				
				UserDetails user = new UserDetails();
				user.setFirstNme(userReq.getFirstName());
				user.setMiddleName(userReq.getMiddleName());
				user.setLastName(userReq.getLastName());
				user.setEmailId(userReq.getEmailId());
				
				UserRole role = getUserRole(userReq.getUserRole());
				user.setUserRole(role);
				
				UserMobile mobile = createUserMobile(userReq);
				user.setMobile(mobile);
				
				UserDetails userDetails = userDetailsRepository.save(user);
				
				UserResp resp = new UserResp();
				resp.setId(userDetails.getId());
				resp.setFirstName(userDetails.getFirstNme());
				resp.setMiddleName(userDetails.getMiddleName());
				resp.setLastName(userDetails.getLastName());
				resp.setMobileNumber(userDetails.getMobile().getMobileNumber());
				resp.setEmailId(userDetails.getEmailId());
				
				return resp;
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
//			userRole.setRole(userReq.getUserRole());
			
			return userRoleRepository.save(userRole);
			
		}catch (Exception e) {
			throw new UserDetailsException(e.getLocalizedMessage());
		}
	}

	@Override
	public UserMobile createUserMobile(UserReq userReq) throws UserDetailsException {
		try {
			UserMobile userMobile = new UserMobile();
			userMobile.setMobileNumber(userReq.getMobileNumber());
			userMobile.setOtp("1234");
			userMobile.setStartTime(new Timestamp(System.currentTimeMillis()));
			userMobile.setExpiryAt(new Timestamp(System.currentTimeMillis() + 40000));
			
			return userMobileRepository.save(userMobile);
		} catch (Exception e) {
			throw new UserDetailsException(e.getLocalizedMessage());
		}
	}

	@Override
	public UserDetails getUser(Integer id) throws UserDetailsException {
		Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
		if(!userDetails.isPresent()) {
			throw new UserDetailsException("User not found", HttpStatus.NOT_FOUND);
		}
		return userDetails.get();
	}

	@Override
	public UserRole getUserRole(Integer roleId) throws UserDetailsException {
		Optional<UserRole> role = userRoleRepository.findById(roleId);
		if(!role.isPresent()) {
			throw new UserDetailsException("Requested user role was not present in the system", HttpStatus.NOT_FOUND);
		}
		return role.get();
	}

	@Override
	public UserMobile getUserMobile(String mobileNumber) throws UserDetailsException {
		Optional<UserMobile> userMbile = userMobileRepository.findById(mobileNumber);
		if(!userMbile.isPresent()) {
			throw new UserDetailsException("Requested mobile Number wasn't mapped to this user", HttpStatus.BAD_REQUEST);
		}
		return userMbile.get();
	}


}
