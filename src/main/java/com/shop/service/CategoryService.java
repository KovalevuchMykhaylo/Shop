package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.entity.Category;

public interface CategoryService {
	
	void saveCategory(Category category);
	
	Category findByOne(Long categoryId);
	
	Category findByName(String name);
	
	void deleteCategory(Long categoryId);

	Page<Category> findPage(Pageable pageable);

	List<Category> findAll();
	

}
