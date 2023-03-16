package com.hutech.loginproject.serviceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.hutech.loginproject.exception.ResourceNotFoundException;
//import com.hutech.loginproject.model.user.User;
//import com.hutech.loginproject.repository.UserRepo;
//@Service
//public class CustomDetailService implements UserDetailsService {
//	@Autowired
//	private UserRepo repo;
//
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////	User user=this.repo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException(" User","email", 0));
////	return user;
////		
////	}



