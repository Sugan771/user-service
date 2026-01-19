package com.user.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String firstNme;
	
	private String middleName;
	
	private String lastName;
	
	private String emailId;
	
//	@OneToMany(mappedBy = "user_details")
	@OneToOne()
	@JoinColumn(name = "userMobileId", unique = true)
	private UserMobile mobile;
	
	@OneToOne()
	@JoinColumn(name = "roleId", unique = true)
	private UserRole userRole;
}
