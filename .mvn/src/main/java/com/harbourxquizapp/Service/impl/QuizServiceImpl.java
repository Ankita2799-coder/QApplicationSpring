package com.harbourxquizapp.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbourxquizapp.Service.QuizService;
import com.harbourxquizapp.model.Quiz;
import com.harbourxquizapp.repository.QuizRepo;
@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	QuizRepo quizRepo;
	@Override
	public Quiz addQuiz(Quiz Quiz) {
		// TODO Auto-generated method stub
		return quizRepo.save(Quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz Quiz) {
		// TODO Auto-generated method stub
		return quizRepo.save(Quiz);
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return quizRepo.findById(quizId).get();
	}

	@Override
	public List<Quiz> getAllQuizs() {
		// TODO Auto-generated method stub
		return quizRepo.findAll();
	}

	@Override
	public void deleteQuiz(Long quiz) {
		// TODO Auto-generated method stub
		quizRepo.deleteById(quiz);
	}
   
}
