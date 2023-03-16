package com.hutech.loginproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.loginproject.model.category.CategoryDto;
import com.hutech.loginproject.service.CategoryDtoService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryDtoService dtoService;

	@PostMapping("/add/category")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto categoryDto2=this.dtoService.crateCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(categoryDto2,HttpStatus.CREATED);	
		
	}
	@GetMapping ("all/category")
	public List<CategoryDto> findAllCategory(){
		List<CategoryDto> categoryDtos=this.dtoService.findAllDetails();
		return categoryDtos;
		
	}
	@GetMapping("/category/{Categoryid}")
	public ResponseEntity<CategoryDto> findById(@PathVariable ("Categoryid") Long id){
		return ResponseEntity.ok(this.dtoService.findByid(id));
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Long id){
		this.dtoService.deleteById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDto> updateById(@RequestBody CategoryDto dto ,@PathVariable("id") Long id){
		CategoryDto categoryDto=this.dtoService.updateCategory(dto, id);
		return ResponseEntity.ok(categoryDto);
	}
	}


