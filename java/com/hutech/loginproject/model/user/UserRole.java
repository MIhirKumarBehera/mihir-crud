package com.hutech.loginproject.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserRole {
	@Id
private long roleid;
private String roleType;

}
