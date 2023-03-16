package com.hutech.loginproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

import com.hutech.loginproject.model.user.UserRole;
import com.hutech.loginproject.repository.RoleRepo;
import com.hutech.loginproject.repository.UserRepo;

@Component
public class DataIntializer {
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private RoleRepo repo2;
	
	public void addRole(ApplicationReadyEvent event) {
		List<UserRole> role= new ArrayList<UserRole>(2);
		role.add(0, new UserRole(1L,"admin"));
		role.add(1, new UserRole(2L,"normalUser"));
		//role.add(2, new UserRole(3L,"customer"));
    	repo2.saveAll(role);
    }

}
