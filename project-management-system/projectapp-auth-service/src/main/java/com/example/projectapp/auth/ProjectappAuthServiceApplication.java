package com.example.projectapp.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectappAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectappAuthServiceApplication.class, args);
	}

}
