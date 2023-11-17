package com.example.projectapp.auth.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.projectapp.auth.model.UserInfo;



public class UserInfoUserDetails implements UserDetails {

	private String name;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserInfoUserDetails(UserInfo userInfo) {
		super();
		this.name = userInfo.getName();
		this.password = userInfo.getPassword();
		this.authorities = Arrays.stream(userInfo.getRoles().split(",")).map(role -> "ROLE_" + role)
				.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
