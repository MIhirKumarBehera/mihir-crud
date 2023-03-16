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
import com.hutech.loginproject.service.CommentDtoService;

@RestController
public class CommentController {
	@Autowired
	private CommentDtoService commentDtoService;

	@PostMapping("/create/{postId}")
	public ResponseEntity<CommentDto> createcomment(@RequestBody CommentDto dto, @PathVariable("postId") Long postId) {
		CommentDto comment = this.commentDtoService.createComment(dto, postId);
		return new ResponseEntity<CommentDto>(HttpStatus.CREATED);
	}
	@DeleteMapping("delete/{deletebyPostId}")
	public ResponseEntity<ApiResponse> deleteBycommentId(@PathVariable ("deleteId") Long id){
		this.commentDtoService.deleteByid(id);
		return new ResponseEntity<>(new ApiResponse("delete Sucsessfully",true),HttpStatus.CREATED);
	}
	@GetMapping("/getAll/comment")
	public ResponseEntity<List<CommentDto>> findAllDetails(){
		List<CommentDto> comments=this.commentDtoService.findAllDetails();
		return new ResponseEntity<List<CommentDto>>(comments,HttpStatus.OK);
		
	}
}
