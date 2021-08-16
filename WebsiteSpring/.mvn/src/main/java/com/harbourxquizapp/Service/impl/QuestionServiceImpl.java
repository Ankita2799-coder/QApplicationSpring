package com.harbourxquizapp.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbourxquizapp.Service.QuestionService;
import com.harbourxquizapp.model.Questions;
import com.harbourxquizapp.model.Quiz;
import com.harbourxquizapp.repository.QuestionRepo;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepo questioRepo;
	@Override
	public Questions addQuestion(Questions Question) {
	return questioRepo.save(Question);

	}

	@Override
	public Questions updateQuestion(Questions Question) {
		return questioRepo.save(Question);
	}

	@Override
	public Questions getQuestion(Long QuestionId) {
		return questioRepo.findById(QuestionId).get();
	}

	@Override
	public List<Questions> getAllQuestions() {
		return questioRepo.findAll();
	}

	@Override
	public void deleteQuestion(Long question) {
		// TODO Auto-generated method stub
		questioRepo.deleteById(question);
	}

	@Override
	public List<Questions> getQuestionsByQuiz(Quiz quiz) {
		return questioRepo.findByQuiz(quiz);
	}

}
