package com.example.projectapp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectapp.auth.dto.JwtToken;
import com.example.projectapp.auth.dto.UserCredentials;
import com.example.projectapp.auth.model.UserInfo;
import com.example.projectapp.auth.service.UserInfoService;
import com.example.projectapp.auth.util.JwtService;

@RestController
@RequestMapping("/auth/api")
public class AuthController {

	@Autowired
	private UserInfoService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String getString() {
		return "Hello";
	}

	@GetMapping("/admin/auth")
	public String getToAdmin() {
		return "Hello admin";
	}

	@GetMapping("/user/auth")
	public String getToUser() {
		return "Hello user";
	}

	@PostMapping("/new/add")
	public UserInfo addUser(@RequestBody UserInfo user) {
		return service.addUser(user);
	}

	@PostMapping("/login/authenticate")
	public JwtToken authenticateAndGetToken(@RequestBody UserCredentials userCredentials) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword()));
		if (authentication.isAuthenticated()) {
			String jwt = jwtService.generateToken(userCredentials.getUsername());
			return new JwtToken(jwt);
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}

}
