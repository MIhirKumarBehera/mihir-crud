package com.hutech.loginproject.model.post;

import java.util.Date;
import java.util.Set;

import com.hutech.loginproject.model.category.Category;
import com.hutech.loginproject.model.comment.Comment;
import com.hutech.loginproject.model.comment.CommentDto;
import com.hutech.loginproject.model.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	@Column(name ="post_title",length = 1000,nullable = false)
	private String title;
	private String imageName;
	private String content;
	private Date adddate;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	@OneToMany
	private Set<Comment> comment;
	

}
