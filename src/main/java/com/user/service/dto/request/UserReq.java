package com.user.service.dto.request;

import lombok.Data;

@Data
public class UserReq {

	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNumber;
	
	private String userRole;
}
