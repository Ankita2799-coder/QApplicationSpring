package com.harbourxquizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harbourxquizapp.model.Questions;
import com.harbourxquizapp.model.Quiz;

public interface QuestionRepo extends JpaRepository<Questions, Long> {

	List<Questions> findByQuiz(Quiz quiz);

}
