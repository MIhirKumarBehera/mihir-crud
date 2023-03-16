package com.hutech.loginproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hutech.loginproject.model.user.UserRole;

public interface RoleRepo extends JpaRepository<UserRole, Long> {
	

}
