package com.hutech.loginproject.model.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class CategoryDto {
 private long id;
 private String categoryname;
 private String description;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
