package com.harbourxquizapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserRole {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private Long userRoleId;
@ManyToOne(fetch=FetchType.EAGER)
private UserModel user;
@ManyToOne(fetch=FetchType.EAGER)
private Role role;
public Long getUserRoleId() {
	return userRoleId;
}
public void setUserRoleId(Long userRoleId) {
	this.userRoleId = userRoleId;
}
public UserModel getUser() {
	return user;
}
public void setUser(UserModel user) {
	this.user = user;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public UserRole(Long userRoleId, UserModel user, Role role) {
	super();
	this.userRoleId = userRoleId;
	this.user = user;
	this.role = role;
}
public UserRole() {
	super();
}

}
