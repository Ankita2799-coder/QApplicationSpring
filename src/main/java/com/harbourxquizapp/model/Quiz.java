package com.harbourxquizapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qId;
	private String title;
	private String description;
	private String maxMarks;
	private String numberofQuestions;
	private String quizTime;
	private boolean active;
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quiz")
	@JsonIgnore
	private Set<Questions> questions=new HashSet<>();
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getqId() {
		return qId;
	}
	public void setqId(Long qId) {
		this.qId = qId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getNumberofQuestions() {
		return numberofQuestions;
	}
	public void setNumberofQuestions(String numberofQuestions) {
		this.numberofQuestions = numberofQuestions;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Quiz() {
		super();
	}
	
	public String getQuizTime() {
		return quizTime;
	}
	public void setQuizTime(String quizTime) {
		this.quizTime = quizTime;
	}
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	

}
