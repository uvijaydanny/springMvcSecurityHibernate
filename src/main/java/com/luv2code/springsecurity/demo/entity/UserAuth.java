package com.luv2code.springsecurity.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserAuth implements Serializable{

	private String username;
	
	private String authority;

	public UserAuth(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public UserAuth() {
	
	}
	
	
}
