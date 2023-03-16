package com.hutech.loginproject.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.loginproject.exception.ResourceNotFoundException;
import com.hutech.loginproject.model.comment.Comment;
import com.hutech.loginproject.model.comment.CommentDto;
import com.hutech.loginproject.model.post.Post;
import com.hutech.loginproject.repository.Commentrepo;
import com.hutech.loginproject.repository.PostRepo;
import com.hutech.loginproject.service.CommentDtoService;
@Service
public class CommentSeriveImpl implements CommentDtoService {
	@Autowired
	private Commentrepo commentrepo;
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Long postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "postId", postId));
		Comment comment=this.mapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment=this.commentrepo.save(comment);
		return this.mapper.map(savedComment, CommentDto.class);
	}
	@Override
	public void deleteByid(Long id) {
		Comment comment=this.commentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "commentId", id));
		this.commentrepo.findById(id);
		
	}
	@Override
	public List<CommentDto> findAllDetails() {
		List<Comment> comments=this.commentrepo.findAll();
		List<CommentDto> commentDtos=comments.stream().map((comment)->this.mapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		return commentDtos;
	}


}
