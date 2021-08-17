package com.harbourxquizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harbourxquizapp.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{
public List<Quiz> findByActive(Boolean b);
}
