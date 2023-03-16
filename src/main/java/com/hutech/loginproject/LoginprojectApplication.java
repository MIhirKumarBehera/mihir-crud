package com.hutech.loginproject;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginprojectApplication  {
	@Autowired
	//private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(LoginprojectApplication.class, args);
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
//	@Override
//	public void run(String... args) throws Exception {
//	System.out.println(this.encoder.encode("dev@678"));
//		
//	}

}
