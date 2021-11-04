package com.ardent.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ardent.spring.core.model.Engine;
import com.ardent.spring.core.model.TataMotors;

@Configuration
public class AppConfiguration {

	@Bean(name = "tata")
	public TataMotors getCar() {
		return new TataMotors(getengine());
	}

	@Bean
	public Engine getengine() {
		return new Engine();
	}

}
