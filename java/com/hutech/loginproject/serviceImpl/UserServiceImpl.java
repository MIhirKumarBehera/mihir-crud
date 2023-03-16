package com.hutech.loginproject.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.loginproject.exception.ResourceNotFoundException;
import com.hutech.loginproject.model.user.User;
import com.hutech.loginproject.model.user.UserDto;
import com.hutech.loginproject.repository.UserRepo;
import com.hutech.loginproject.service.UserDtoService;
@Service
public class UserServiceImpl implements UserDtoService {
 @Autowired
 private UserRepo userRepo;
 
 @Autowired
 private ModelMapper mapper;
 
	@Override
	public UserDto createuser(UserDto userdto) {
		User user=this.dtoToUser(userdto);
		User saveuser=this.userRepo.save(user);
		return this.userToDto(saveuser);
		
	}

	@Override
	public UserDto updateUser(UserDto user, Long id){
		User user2=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		
		user2.setName(user.getName());
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setAbout(user.getAbout());
		user2.setPassword(user.getPassword());
		
		User updateuser=this.userRepo.save(user2);
		UserDto userDto1=this.userToDto(updateuser);
		
		return userDto1;
		
		
	}

	@Override
	public UserDto findbyId(Long id) {
	
		User user=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		return this.userToDto(user);
	}

	@Override
	public void deleteById(Long id) {
		User user=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		this.userRepo.deleteById(id);
		
	}
	private User dtoToUser(UserDto dto) {
		User user=this.mapper.map(dto, User.class);
//		user.setId(dto.getId());
//		user.setName(dto.getName());
//		user.setEmail(dto.getEmail());
//		user.setPassword(dto.getPassword());
//		user.setAbout(dto.getAbout());
//		return user;
		return user;
//		
	}
	private UserDto userToDto(User user) {
		UserDto dto=this.mapper.map(user, UserDto.class);
		//UserDto dto=new UserDto();
//		dto.setId(user.getId());
//		dto.setName(user.getName());
//		dto.setEmail(user.getEmail());
//		dto.setPassword(user.getPassword());
//		dto.setAbout(user.getAbout());
//		return dto;
		return dto;
	}

	
	@Override
	public List<UserDto> getAllUesr() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> userdto1=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		 return userdto1;
	}

	

}
