package com.ardent.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ardent.spring.core.beans.Employee;

@Configuration
public class EmployeeConfig {

	@Bean
	public Employee employee() {
		return new Employee();
	}
}
