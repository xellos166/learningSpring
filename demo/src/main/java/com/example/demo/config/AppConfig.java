package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Step :5 
@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class AppConfig {

}
