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

import com.harbourxquizapp.Service.QuizService;
import com.harbourxquizapp.model.Quiz;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired 
	private QuizService QuizService;
	//add Quiz
    @PostMapping("/save")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz Quiz)
	{
		Quiz Quiz1=this.QuizService.addQuiz(Quiz);
		return ResponseEntity.ok(Quiz1);
	}
    //get Quiz
    @GetMapping("/{QuizId}")
	public ResponseEntity<?> getQuiz(@PathVariable("QuizId") Long Quiz)
	{
		Quiz Quiz1=this.QuizService.getQuiz(Quiz);
		return ResponseEntity.ok(Quiz1);
	}
  //get all Quiz
    @GetMapping("/categories")
	public ResponseEntity<?> getAllCategories()
	{
		List<Quiz> categories=this.QuizService.getAllQuizs();
		return ResponseEntity.ok(categories);
	}
  //update Quiz
    @PutMapping("/update")
	public ResponseEntity<?> updateCategories(@RequestBody Quiz Quiz)
	{
		Quiz Quiz1=this.QuizService.updateQuiz(Quiz);
		return ResponseEntity.ok(Quiz1);
	}
  //update Quiz
    @DeleteMapping("/{QuizId}")
	public ResponseEntity<?> deleteCategories(@PathVariable("QuizId") Long Quiz)
	{
		this.QuizService.deleteQuiz(Quiz);
		return ResponseEntity.ok("Deleted Successfully");
	}
}
