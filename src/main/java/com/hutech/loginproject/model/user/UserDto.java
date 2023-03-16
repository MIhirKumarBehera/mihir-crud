package com.hutech.loginproject.model.user;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	
private long id;
@NotNull
//@Size(min=4,message="username must be 4character ")
private String name;

@Email(message="email id is not valid")
private String email;
@NotNull
//@Size(min=3,max=10,message="password should be min 3character & max 10 character")
private String password;
@NotNull
private String about;
}
