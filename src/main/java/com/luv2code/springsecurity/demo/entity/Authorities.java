package com.luv2code.springsecurity.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="authorities")
@Table(name="authorities")
public class Authorities {

	@EmbeddedId
	private UserAuth userAuth;

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}
	
	
}
