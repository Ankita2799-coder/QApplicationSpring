package com.tutorialproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Video {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int videoId;
	String src;
	String list;
	String description;
	String title;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Cards card;
	
	
	public Video() {
		super();
	}

	public Video(int videoId, String src, String list, String description, String title) {
		super();
		this.videoId = videoId;
		this.src = src;
		this.list = list;
		this.description = description;
		this.title = title;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public Video(String src, String list) {
		super();
		this.src = src;
		this.list = list;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}

}
