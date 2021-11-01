package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ardent.spring.core.model.Car;
import com.ardent.spring.core.model.TataMotors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Config loaded ..");
		Car c = context.getBean("tata", TataMotors.class);
		System.out.println(c);
	}
}
