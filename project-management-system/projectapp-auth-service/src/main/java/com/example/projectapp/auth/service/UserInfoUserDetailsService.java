package com.example.projectapp.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.projectapp.auth.dto.UserInfoUserDetails;
import com.example.projectapp.auth.model.UserInfo;
import com.example.projectapp.auth.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = repository.findByName(username);

		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() ->new UsernameNotFoundException("user not found" + username));
	}

}
