package com.hutech.loginproject.service;

import java.util.List;

import com.hutech.loginproject.model.post.Post;
import com.hutech.loginproject.model.post.PostDto;

public interface PostDtoService {
	PostDto createPost(PostDto dto, Long userId, Long categoryId);

	List<PostDto> findallPostDetails();

	PostDto updatePostById(PostDto dto, Long id);

	PostDto findByPostId(Long id);

	public void deleteBypostId(Long id);

	List<PostDto> getPostByUserId(Long userId);

	List<PostDto> getPostByCategoryId(Long categoryId);
}
