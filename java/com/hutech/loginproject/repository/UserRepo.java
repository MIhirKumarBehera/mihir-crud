package com.hutech.loginproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.loginproject.model.user.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
