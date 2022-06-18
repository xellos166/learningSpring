package com.ardent.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Profile("prod")
@SpringBootApplication
public class ConceptSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(ConceptSpringBootApplication.class);
		// application.setAdditionalProfiles("prod");
		application.run(args);
		// SpringApplication.run(ConceptSpringBootApplication.class, args);
	}

}
