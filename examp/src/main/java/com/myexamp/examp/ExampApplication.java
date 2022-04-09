package com.myexamp.examp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampApplication {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("CONTEXT LOADED...");
		Student s=(Student)context.getBean("student");
		Student s2=context.getBean("student", Student.class);
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
	}

}
