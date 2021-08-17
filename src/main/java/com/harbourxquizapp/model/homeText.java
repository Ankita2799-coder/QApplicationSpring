package com.harbourxquizapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class homeText {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long home_Id;
private String homeText;
public Long getHome_Id() {
	return home_Id;
}
public void setHome_Id(Long home_Id) {
	this.home_Id = home_Id;
}
public String getHomeText() {
	return homeText;
}
public void setHomeText(String homeText) {
	this.homeText = homeText;
}

}
