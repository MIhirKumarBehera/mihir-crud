//package com.hutech.loginproject.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.hutech.loginproject.serviceImpl.CustomDetailService;
//
//
//@Configuration
//public class SecurityConfiguration {
//	@Autowired
//	private CustomDetailService customDetailService;
//	@Bean
//	public SecurityFilterChain filetChain(HttpSecurity security) throws Exception {
//		security.csrf().
//		disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
//		return security.build();
//	}
//	
//
//	public void configure(AuthenticationManagerBuilder builder) throws Exception{
//		builder.userDetailsService(this.customDetailService).passwordEncoder(passwordEncoder());
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//		
	


