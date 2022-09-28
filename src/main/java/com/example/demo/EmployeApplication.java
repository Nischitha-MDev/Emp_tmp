package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.example.demo.controller", "com.example.demo.entities","com.example.demo.repository","com.example.demo.service"})
public class EmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}
}