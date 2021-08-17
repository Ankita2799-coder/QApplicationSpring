package com.harbourxquizapp.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.harbourxquizapp.model.Quiz;
@Service
public interface QuizService {
	  public Quiz addQuiz(Quiz Quiz);
	  public Quiz updateQuiz(Quiz Quiz);
	  public Quiz getQuiz(Long quizId);
	  public List<Quiz> getAllQuizs();
	public void deleteQuiz(Long quiz);
	public List<Quiz> getActiveQuizzes();
}
