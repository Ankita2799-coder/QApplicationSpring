package com.harbourxquizapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harbourxquizapp.Service.QuestionService;
import com.harbourxquizapp.Service.QuizService;
import com.harbourxquizapp.model.Questions;
import com.harbourxquizapp.model.Quiz;
@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired 
	private QuestionService QuestionService;
	@Autowired 
	private QuizService quizService;
		//add Question
	    @PostMapping("/save")
		public ResponseEntity<?> addQuestion(@RequestBody Questions Question)
		{
			Questions Question1=this.QuestionService.addQuestion(Question);
			return ResponseEntity.ok(Question1);
		}
	    //get Question
	    @GetMapping("/{questionId}")
		public ResponseEntity<?> getQuestion(@PathVariable("questionId") Long Question)
		{
			Questions Question1=this.QuestionService.getQuestion(Question);
			return ResponseEntity.ok(Question1);
		}
	  //get all Question
	    @GetMapping("/categories")
		public ResponseEntity<?> getAllCategories()
		{
			List<Questions> categories=this.QuestionService.getAllQuestions();
			return ResponseEntity.ok(categories);
		}
	  //update Question
	    @PutMapping("/update")
		public ResponseEntity<?> updateCategories(@RequestBody Questions Question)
		{
			Questions Question1=this.QuestionService.updateQuestion(Question);
			return ResponseEntity.ok(Question1);
		}
	  //update Question
	    @DeleteMapping("/{QuestionId}")
		public ResponseEntity<?> deleteCategories(@PathVariable("QuestionId") Long Question)
		{
		this.QuestionService.deleteQuestion(Question);
			return ResponseEntity.ok("deletion successfull");
		}
	  //get Question by quiz
	    //get Question
	    @GetMapping("quiz/{quizId}")
		public ResponseEntity<?> getQuestionbyauiz(@PathVariable("quizId") Long quizid)
		{
	    	Quiz quiz=quizService.getQuiz(quizid);
	    	Set<Questions> questions=quiz.getQuestions();
	    	List list=new ArrayList<>(questions);
	    	if(list.size()>Integer.parseInt(quiz.getNumberofQuestions()))
	    	{
	    		list=list.subList(0, Integer.parseInt(quiz.getNumberofQuestions())+1);
	    		
	    	}
	    	Collections.shuffle(list);
			return ResponseEntity.ok(list);
		}
	    @GetMapping("quiz/all/{quizId}")
		public ResponseEntity<?> getQuestionbyquizadmin(@PathVariable("quizId") Long quizid)
		{
	    	Quiz quiz=quizService.getQuiz(quizid);
	    	Set<Questions> questions=quiz.getQuestions();
			return ResponseEntity.ok(questions);
		}
}
