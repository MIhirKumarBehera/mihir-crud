package com.hutech.loginproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.loginproject.model.post.Post;
import com.hutech.loginproject.model.post.PostDto;
import com.hutech.loginproject.response.ApiResponse;
import com.hutech.loginproject.service.FileService;
import com.hutech.loginproject.service.PostDtoService;

@RestController
public class PostController {
	@Autowired
	private PostDtoService dtoService;
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	String path;
	
	
	
	@PostMapping("/user")
   public ResponseEntity<PostDto> createPost(@RequestBody PostDto dto, @PathVariable Long userId,@PathVariable Long categoryId){
		PostDto post=this.dtoService.createPost(dto,userId,categoryId);
		return new ResponseEntity<PostDto>(post,HttpStatus.CREATED);
		
	}
	@GetMapping("user/{userId}/posts")
	public List<PostDto> findByUserId(@PathVariable ("userId") Long id){
	 List<PostDto> dto=this.dtoService.getPostByUserId(id);
	 return dto;
	}
	@GetMapping("category/{categoryId}/posts")
	public  List<PostDto> findBycategoryId(@PathVariable ("categoryId") Long id){
		List<PostDto> dtos=this.dtoService.getPostByCategoryId(id);
		return dtos;
	}
	@GetMapping("/findAll/posts")
	public ResponseEntity<List<PostDto>> findAllDetails(){
		//List<Post> post=this.dtoService.findallPostDetails();
		return ResponseEntity.ok(this.dtoService.findallPostDetails());
	}
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> findByPostId(@PathVariable ("postId") Long id){
		PostDto dto=this.dtoService.findByPostId(id);
		return new ResponseEntity<PostDto>(dto,HttpStatus.OK);
	}
	@PutMapping("post/{postId}")
	public ResponseEntity<PostDto> updateByPostId(@RequestBody PostDto dto,@PathVariable ("postId" )Long id){
		PostDto dto2= this.dtoService.updatePostById(dto, id);
		return new ResponseEntity<PostDto>(dto2,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{deleteId}")
	public ApiResponse deleteByPostId(@PathVariable ("id") Long id) {
		this.dtoService.deleteBypostId(id);
		return new ApiResponse("delete Sucsess", true);
	}
	@PostMapping("/post/uploadImage/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,@PathVariable Long postId) throws IOException{
		String filename=this.fileService.uploadimage(path,image);
		PostDto dto=this.dtoService.findByPostId(postId);
		dto.setImageName(filename);
		PostDto updatePost=this.dtoService.updatePostById(dto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
	}
	
	
}

