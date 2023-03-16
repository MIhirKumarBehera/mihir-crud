package com.hutech.loginproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.loginproject.model.comment.Comment;
import com.hutech.loginproject.model.comment.CommentDto;
import com.hutech.loginproject.response.ApiResponse;
import com.hutech.loginproject.service.CommentService;

import lombok.Getter;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/create/comment/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable ("postId") Long id){
		CommentDto comment=this.commentService.createComment(commentDto,id);
		return new ResponseEntity<CommentDto>(comment,HttpStatus.CREATED);
	}
	 @DeleteMapping("delete/comment/{cId}")
	public ApiResponse deleteByid(@PathVariable ("cId") long id) {
		this.commentService.deleteBycommentid(id);
		return new ApiResponse("deletes sucsessully", true);
		
	}
	@GetMapping("/get/allDetails")
	public ResponseEntity<List<CommentDto>> findAllCommentDetails(){
		List<CommentDto> comments=this.commentService.findallCommentDetails();
		return new ResponseEntity<List<CommentDto>> (comments,HttpStatus.OK);
	}


}
