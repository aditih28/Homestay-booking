package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.example.demo.*")
@SpringBootApplication
public class RoleSpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleSpringBootRestApplication.class, args);
	}

}
