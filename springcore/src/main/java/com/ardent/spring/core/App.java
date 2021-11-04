package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ardent.spring.core.config.AppConfiguration;
import com.ardent.spring.core.model.TataMotors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);// new
		// ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Config loaded ..");
		TataMotors c = context.getBean("tata", TataMotors.class);
		c.start();
	}
}
