package com.ardent.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.ardent.spring.core.Course;
import com.ardent.spring.core.Student;

@Configuration
public class AppConfiguration {

	@Bean
	@Lazy
	@Scope("prototype")
	public Student student() {
		return new Student("Moupali", 100, course());
	}

	@Bean
	@Lazy
	public Course course() {
		return new Course("Spring", 101);
	}

}
