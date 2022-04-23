package com.myexamp.examp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.myexamp.examp.Address;
import com.myexamp.examp.Student;

@Configuration
public class BeansConfig {

	@Bean
	public Address getAddress() {
		Address a = new Address("Bengaluru", "AECS Layout");
		return a;
	}

	@Bean(name = "student")
	@Scope(scopeName = "singleton")
	public Student getStudent() {
		return new Student(100, "Jerry", getAddress());
	}

}
