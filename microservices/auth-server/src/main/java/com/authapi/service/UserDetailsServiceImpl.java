package com.authapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.authapi.model.User;
import com.authapi.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository repo;
	
	 public UserDetails loadUserByUsername(String username) {
		User user =  repo.findByUsername(username);
		return new UserDetailsModel(user);
	}
	 
	 
	
}
