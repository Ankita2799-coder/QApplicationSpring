package com.tutorialproject.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private String Authority;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return Authority;
	}
	public Authority(String authority) {
		super();
		Authority = authority;
	}
	

}
