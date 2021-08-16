package com.harbourxquizapp.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbourxquizapp.Service.CategoryService;
import com.harbourxquizapp.model.Category;
import com.harbourxquizapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepo categoryRepo;
	@Override
	public Category addCategory(Category category) {
	return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
	return categoryRepo.save(category);
	}

	@Override
	public Category getCategory(Long categoryId) {
		return categoryRepo.findById(categoryId).get();
	}

	@Override
	public List<Category> getAllCategories() {
		
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(Long category) {
		// TODO Auto-generated method stub
		categoryRepo.deleteById(category);
	}



}
