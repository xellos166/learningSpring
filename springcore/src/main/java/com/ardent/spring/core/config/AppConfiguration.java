package com.ardent.spring.core.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ardent.spring.core.model.Engine;
import com.ardent.spring.core.model.EngineType;
import com.ardent.spring.core.model.TataMotors;

@Configuration
public class AppConfiguration {

	@Bean(name = "tata")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TataMotors getCar() {
		System.out.println("getCar called..");
		TataMotors t = new TataMotors(getengine());
		return t;
	}

	@Bean(name = "engine")
	public Engine getengine() {
		System.out.println("getengine called..");
		return new Engine(getengineType());
	}

	@Bean(name = "engineType")
	public EngineType getengineType() {
		System.out.println("getEngineType called..");
		EngineType et = new EngineType();
		et.setType("BS6");
		return et;
	}

}
