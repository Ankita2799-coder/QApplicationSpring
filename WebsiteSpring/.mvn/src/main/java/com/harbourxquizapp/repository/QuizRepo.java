package com.harbourxquizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harbourxquizapp.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
