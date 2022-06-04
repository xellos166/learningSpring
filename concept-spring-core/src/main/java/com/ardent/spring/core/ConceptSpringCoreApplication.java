package com.ardent.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ardent.spring.core.beans.Car;
import com.ardent.spring.core.beans.Employee;
import com.ardent.spring.core.beans.Engine;
import com.ardent.spring.core.beans.Valve;
import com.ardent.spring.core.config.AppConfig;
import com.ardent.spring.core.config.EmployeeConfig;

public class ConceptSpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, EmployeeConfig.class);
		// new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("container loaded.........");

		Valve v = context.getBean("valve", Valve.class);
		System.out.println(v);

		Engine engine = (Engine) context.getBean("engine");
		System.out.println(engine);
		System.out.println(engine.hashCode());

		Engine engine1 = (Engine) context.getBean("engine");
		System.out.println(engine1);
		System.out.println(engine1.hashCode());

		Car car = context.getBean("car", Car.class);
		System.out.println(car);
		System.out.println(car.hashCode());

		Employee e = context.getBean("employee", Employee.class);
		System.out.println(e);

	}

}
