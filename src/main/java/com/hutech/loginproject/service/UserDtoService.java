 package com.hutech.loginproject.service;

import java.util.List;

import com.hutech.loginproject.model.user.UserDto;

public interface UserDtoService {
UserDto createuser(UserDto user);
UserDto updateUser(UserDto user,Long id);
UserDto findbyId(Long id);
List<UserDto> getAllUesr();
void deleteById(Long id);
}
