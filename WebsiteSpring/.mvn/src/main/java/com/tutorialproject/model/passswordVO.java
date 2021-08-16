package com.tutorialproject.model;

public class passswordVO {
private String username;
private String oldpassword;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getOldpassword() {
	return oldpassword;
}
public void setOldpassword(String oldpassword) {
	this.oldpassword = oldpassword;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public passswordVO(String username, String oldpassword, String password) {
	super();
	this.username = username;
	this.oldpassword = oldpassword;
	this.password = password;
}
public passswordVO() {
	super();
}

}
