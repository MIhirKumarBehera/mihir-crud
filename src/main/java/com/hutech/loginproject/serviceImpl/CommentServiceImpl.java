package com.hutech.loginproject.serviceImpl;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.loginproject.exception.ResourceNotFoundException;
import com.hutech.loginproject.model.comment.Comment;
import com.hutech.loginproject.model.comment.CommentDto;
import com.hutech.loginproject.model.post.Post;
import com.hutech.loginproject.repository.CommentRepo;
import com.hutech.loginproject.repository.PostRepo;
import com.hutech.loginproject.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PostRepo postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto,Long postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "id", postId));
		Comment comment=this.mapper.map(commentDto,Comment.class);
		comment.setPost(post);
		Comment saveComment=this.commentRepo.save(comment);
		return this.mapper.map(saveComment, CommentDto.class);
		
	}

	@Override
	public void deleteBycommentid(Long id) {
		this.commentRepo.deleteById(id);
		
	}

	@Override
	public List<CommentDto> findallCommentDetails() {
		List<Comment> comment=this.commentRepo.findAll();
		List<CommentDto> commentDtos=comment.stream().map((cmnnt)-> this.mapper.map(cmnnt, CommentDto.class)).collect(Collectors.toList());
		return commentDtos;
	}
}
