package com.tutorialproject.model;

public class JwtResponse {
private final String jwt;
public String getJwt() {
	return jwt;
}

public JwtResponse(String jwt) {
	super();
	this.jwt = jwt;
}

}
