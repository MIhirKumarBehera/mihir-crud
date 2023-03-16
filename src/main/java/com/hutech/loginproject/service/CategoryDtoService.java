package com.hutech.loginproject.service;

import java.util.List;

import com.hutech.loginproject.model.category.CategoryDto;

public interface CategoryDtoService {

	CategoryDto crateCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(CategoryDto dto, Long id);

	CategoryDto findByid(Long id);

	List<CategoryDto> findAllDetails();

	void deleteById(Long id);

}
