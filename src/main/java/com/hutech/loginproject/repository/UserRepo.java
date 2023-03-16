package com.hutech.loginproject.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hutech.loginproject.model.user.User;

public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);

}
