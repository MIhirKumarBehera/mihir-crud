package com.hutech.loginproject.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.loginproject.exception.ResourceNotFoundException;
import com.hutech.loginproject.model.category.Category;
import com.hutech.loginproject.model.category.CategoryDto;
import com.hutech.loginproject.repository.CategoryRepo;
import com.hutech.loginproject.service.CategoryDtoService;

@Service
public class CategoryServiceImpl implements CategoryDtoService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public CategoryDto crateCategory(CategoryDto categoryDto) {
		Category category=this.mapper.map(categoryDto, Category.class);
		Category saved=this.categoryRepo.save(category);
		return this.mapper.map(saved, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto dto, Long id) {
		Category cat=this.categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
		cat.setCategoryname(dto.getCategoryname());
		cat.setId(dto.getId());
		cat.setDescription(dto.getDescription());
		Category savedDetails=this.categoryRepo.save(cat);
		return this.mapper.map(savedDetails, CategoryDto.class);
	}

	@Override
	public CategoryDto findByid(Long id) {
	Category category=this.categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("category", "id", id));
	return this.mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> findAllDetails() {
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos=categories.stream().map((cat)->this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("category", "id", id));
		this.categoryRepo.deleteById(id);
	}

	
}
