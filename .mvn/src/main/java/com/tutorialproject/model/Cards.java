package com.tutorialproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cards {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cardId;
	String title;
	String image;
	String content;
	@OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
	Set<Video> videos=new HashSet<>();
	
	public Cards() {
		super();
	}
	public Cards(int card, String title, String image, String content) {
		super();
		this.cardId = card;
		this.title = title;
		this.image = image;
		this.content = content;
	}
	public int getCard() {
		return cardId;
	}
	public void setCard(int card) {
		this.cardId = card;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
