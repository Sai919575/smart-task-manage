package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.demo.controller","com.example.demo.entity","com.example.demo.exception","com.example.demo.repository"})
public class AdminViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminViewApplication.class, args);
	}

}
