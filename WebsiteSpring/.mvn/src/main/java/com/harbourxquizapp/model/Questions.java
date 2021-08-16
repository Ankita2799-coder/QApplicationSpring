package com.harbourxquizapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Questions {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quesId;
	private String content;
	private String image;
	private String answer;
	@ManyToOne(fetch=FetchType.EAGER)
	private Quiz quiz;
	public Long getQuesId() {
		return quesId;
	}
	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Questions(Long quesId, String content, String image, String answer, Quiz quiz) {
		super();
		this.quesId = quesId;
		this.content = content;
		this.image = image;
		this.answer = answer;
		this.quiz = quiz;
	}
	public Questions() {
		super();
	}

}
