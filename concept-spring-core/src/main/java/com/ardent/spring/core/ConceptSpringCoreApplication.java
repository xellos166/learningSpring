package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ardent.spring.core.beans.Car;
import com.ardent.spring.core.beans.Engine;

public class ConceptSpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("container loaded.........");

		Engine engine = (Engine) context.getBean("engine");
		System.out.println(engine);
		System.out.println(engine.hashCode());

		Car car = context.getBean("car", Car.class);
		System.out.println(car);
		System.out.println(car.hashCode());
	}

}
