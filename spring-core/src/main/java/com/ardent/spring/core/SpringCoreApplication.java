package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ardent.spring.core.config.AppConfiguration;

//@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		System.out.println("comment for sourav");
		// SpringApplication.run(SpringCoreApplication.class, args);
		ApplicationContext context = // new ClassPathXmlApplicationContext("beans.xml");
				new AnnotationConfigApplicationContext(AppConfiguration.class);// new
		System.out.println("Config loaded ..");

		Student s = (Student) context.getBean("student");
		Student s1 = context.getBean("student", Student.class);
		System.out.println("Student loaded from config s :" + s);
		System.out.println("hash code " + s.hashCode());

		System.out.println("Student loaded from config for s1:" + s1);
		System.out.println("hash code s1 :" + s1.hashCode());

	}

}
