package com.user.service.services.dto.response;

import lombok.Data;

@Data
public class UserResp {
	
	private Integer id;

	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNumber;
}
