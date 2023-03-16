package com.hutech.loginproject.model.post;

import java.util.Date;

import com.hutech.loginproject.model.category.CategoryDto;
import com.hutech.loginproject.model.comment.Comment;
import com.hutech.loginproject.model.comment.CommentDto;
import com.hutech.loginproject.model.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private String title;
	private String content;
	private String imageName;
	private Date AddedDate;
	private CategoryDto category;
	private UserDto user;
	private Comment comment;
}
