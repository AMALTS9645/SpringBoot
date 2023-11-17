package com.projectapp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectappGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectappGatewayApplication.class, args);
	}

}
