package com.harbourxquizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harbourxquizapp.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
