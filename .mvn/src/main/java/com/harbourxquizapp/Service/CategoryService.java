package com.harbourxquizapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harbourxquizapp.model.Category;


@Service
public interface CategoryService {
  public Category addCategory(Category category);
  public Category updateCategory(Category category);
  public Category getCategory(Long categoryId);
  public List<Category> getAllCategories();
public void deleteCategory(Long category);
}
