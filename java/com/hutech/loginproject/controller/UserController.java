package com.hutech.loginproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hutech.loginproject.model.user.UserDto;
import com.hutech.loginproject.service.UserDtoService;

@RestController
public class UserController {
	
	@Autowired
	private UserDtoService dtoService;

	@PostMapping("/create/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto){
		UserDto user=this.dtoService.createuser(dto);
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}
	
	@PutMapping("/{UserId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto dto,  @PathVariable("UserId") Long id){
		UserDto userDto=this.dtoService.updateUser(dto, id);
		return  ResponseEntity.ok(userDto);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable ("Id") Long id){
		this.dtoService.deleteById(id);
	}
	@GetMapping("/allDetails")
	public ResponseEntity<List<UserDto>> findAllDetails(){
		return ResponseEntity.ok( this.dtoService.getAllUesr());
		
	}
	@GetMapping ("/{id}")
	public ResponseEntity<UserDto> findByid(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.dtoService.findbyId(id));
	}
	
}
