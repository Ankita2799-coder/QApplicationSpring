package com.harbourxquizapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harbourxquizapp.model.Questions;
import com.harbourxquizapp.model.Quiz;
@Service
public interface QuestionService {
	  public Questions addQuestion(Questions Question);
	  public Questions updateQuestion(Questions Question);
	  public Questions getQuestion(Long QuestionId);
	  public List<Questions> getAllQuestions();
	public void deleteQuestion(Long question);
	public List<Questions> getQuestionsByQuiz(Quiz quiz);
}
