package com.harbourxquizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harbourxquizapp.Service.CategoryService;
import com.harbourxquizapp.model.Category;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {
	
@Autowired 
private CategoryService categoryService;
	//add category
    @PostMapping("/save")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
	{
		Category category1=this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
    //get category
    @GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long category)
	{
		Category category1=this.categoryService.getCategory(category);
		return ResponseEntity.ok(category1);
	}
  //get all category
    @GetMapping("/categories")
	public ResponseEntity<?> getAllCategories()
	{
		List<Category> categories=this.categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}
  //update category
    @PutMapping("/update")
	public ResponseEntity<?> updateCategories(@RequestBody Category category)
	{
		Category category1=this.categoryService.updateCategory(category);
		return ResponseEntity.ok(category1);
	}
  //update category
    @DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategories(@PathVariable("categoryId") Long category)
	{
	this.categoryService.deleteCategory(category);
		return ResponseEntity.ok("deleted successfully");
	}
}
