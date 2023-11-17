package com.example.projectapp.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectapp.auth.model.UserInfo;
import com.example.projectapp.auth.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserInfoRepository repository;
	
	@Override
	public UserInfo addUser(UserInfo user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}

	
}
