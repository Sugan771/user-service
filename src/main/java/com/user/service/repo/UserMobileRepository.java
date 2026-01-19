package com.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entity.UserMobile;

@Repository
public interface UserMobileRepository extends JpaRepository<UserMobile, String> {

}
