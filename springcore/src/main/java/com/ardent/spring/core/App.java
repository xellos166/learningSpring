package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ardent.spring.core.config.AppConfiguration;
import com.ardent.spring.core.model.EngineType;
import com.ardent.spring.core.model.TataMotors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);// new
		// new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Config loaded ..");
		TataMotors c = context.getBean("tata", TataMotors.class);
		c.start();
		System.out.println(c.hashCode());
		// ------------------------
		TataMotors c2 = context.getBean("tata", TataMotors.class);
		c2.start();
		System.out.println(c2.hashCode());
		// -----------------------------
		EngineType et = (EngineType) context.getBean("engineType");
		System.out.println(et);
	}
}
