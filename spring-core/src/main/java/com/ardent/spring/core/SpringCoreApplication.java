package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringCoreApplication.class, args);
		ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
		//new AnnotationConfigApplicationContext(AppConfiguration.class);// new
		System.out.println("Config loaded ..");
		
		Student s= (Student) context.getBean("student");
		System.out.println("Student loaded from config s :"+s);
		System.out.println("hash code "+s.hashCode());
		
		Student s1= (Student) context.getBean("student");
		System.out.println("Student loaded from config for s1:"+s1);
		System.out.println("hash code s1 :"+s1.hashCode());
		
	}

}
