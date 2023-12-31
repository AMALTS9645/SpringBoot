package com.authapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authapi.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
