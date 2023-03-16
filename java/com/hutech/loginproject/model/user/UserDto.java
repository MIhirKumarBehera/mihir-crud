package com.hutech.loginproject.model.user;





import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	
private long id;
@NotEmpty
@Size(min=4,message="username must be 4character ")
private String name;

@Email(message="email id is not valid")
private String email;
@NotEmpty
@Size(min=3,max=10,message="password should be min 3character & max 10 character")
private String password;
@NotEmpty
private String about;
}
