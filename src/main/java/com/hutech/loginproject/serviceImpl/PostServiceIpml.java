package com.hutech.loginproject.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.loginproject.exception.ResourceNotFoundException;
import com.hutech.loginproject.model.category.Category;
import com.hutech.loginproject.model.post.Post;
import com.hutech.loginproject.model.post.PostDto;
import com.hutech.loginproject.model.user.User;
import com.hutech.loginproject.repository.CategoryRepo;
import com.hutech.loginproject.repository.PostRepo;
import com.hutech.loginproject.repository.UserRepo;
import com.hutech.loginproject.service.PostDtoService;

@Service
public class PostServiceIpml implements PostDtoService {
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepo repo;
	@Autowired
	private CategoryRepo categoryRepo;

//	@Override
//	public List<Post> findallPostDetails() {
//		List<Post> posts = this.postRepo.findAll();
//		List<PostDto> dtos = posts.stream().map((post1) -> this.mapper.map(post1, PostDto.class))
//				.collect(Collectors.toList());
//		return this.mapper.map(dtos, Post.class);
//
//	}

//	@Override
//	public Post updatePostById(PostDto dto, Long id) {
//		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
//		return this.mapper.map(post, PostDto.class);
//	}
//
//	@Override
//	public PostDto findByPostId(Long id) {
//		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
//		return this.mapper.map(post, PostDto.class);
//	}

	@Override
	public void deleteBypostId(Long id) {
		this.postRepo.deleteById(id);

	}

	@Override
	public PostDto createPost(PostDto dto, Long userId, Long categoryId) {
		User user = this.repo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
		Post post = this.mapper.map(dto, Post.class);
		post.setImageName("default img");
		post.setAdddate(new Date());
		post.setUser(user);
		post.setCategory(category);

		Post post2 = this.postRepo.save(post);
		return this.mapper.map(post2, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByUserId(Long userId) {
		User user = this.repo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userid", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> dtos = posts.stream().map((post) -> this.mapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return dtos;

	}

	@Override
	public List<PostDto> getPostByCategoryId(Long categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		List<PostDto> dtos = posts.stream().map((post) -> this.mapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<PostDto> findallPostDetails() {
		List<Post> posts = this.postRepo.findAll();
		List<PostDto> dtos = posts.stream().map((dto) -> this.mapper.map(dto, PostDto.class))
				.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public PostDto updatePostById(PostDto dto, Long id) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "userId", id));
return this.mapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findByPostId(Long id) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "postid", id));
		return this.mapper.map(post, PostDto.class);
	}

}
