package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.UserDetails;

public interface UserDetailsDAO {

	public void addUsersAuthorizationDetails(UserDetails userdetails);

	public List<UserDetails> getUserAuthDetails();
}
