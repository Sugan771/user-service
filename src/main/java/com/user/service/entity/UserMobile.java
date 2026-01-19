package com.user.service.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class UserMobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userMobileId;
	
	private String mobileNumber;
	
	private String otp;
	
	private Timestamp startTime;
	
	private Timestamp expiryAt;
	
}
