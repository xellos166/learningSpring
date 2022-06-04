package com.ardent.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.ardent.spring.core.beans.Car;
import com.ardent.spring.core.beans.Engine;
import com.ardent.spring.core.beans.Valve;

@Configuration
public class AppConfig {

	@Bean
	public Car car() {
		Car c = new Car();
		c.setColor("red");
		c.setEngine(engine());
		c.setModelname("Alto");
		return c;
	}

	@Bean(name = "engine")
	@Scope("prototype")
	public Engine engine() {
		return new Engine("petrol", "1500cc", valve());
	}

	@Bean(name = "valve")
	@Lazy
	public Valve valve() {
		return new Valve(5, "Brass");
	}

}
