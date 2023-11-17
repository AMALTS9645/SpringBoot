package com.example.projectapp.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectapp.auth.model.UserInfo;



public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

	public Optional<UserInfo> findByName(String name);
}
