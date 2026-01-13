package com.user.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	
	private String role; 
}
