package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
import com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public Category findByOne(Long categoryId) {
		return categoryRepository.findOne(categoryId);
	}

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		categoryRepository.delete(categoryId);
	}

	@Override
	public Page<Category> findPage(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
