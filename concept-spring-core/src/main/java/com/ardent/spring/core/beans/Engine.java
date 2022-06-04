package com.ardent.spring.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Engine {
	private String engineType;
	private String enginePower;
	private Valve valve;

	@PostConstruct
	public void afterInit() {
		System.out.println("the Engie bean is just being created.....***");
	}

	@PreDestroy
	public void beforeDestroy() {
		System.out.println("Engine bean is going to be destryed....");
	}

	public Engine(String engineType, String enginePower, Valve valve) {
		this.engineType = engineType;
		this.enginePower = enginePower;
		this.valve = valve;
		System.out.println("3 areg constuctor called for Engine");
	}

	public Valve getValve() {
		return valve;
	}

	public void setValve(Valve valve) {
		this.valve = valve;
	}

	@Override
	public String toString() {
		return "Engine [engineType=" + engineType + ", enginePower=" + enginePower + "]";
	}

	public Engine() {

	}

	public Engine(String engineType, String enginePower) {
		this.engineType = engineType;
		this.enginePower = enginePower;
		System.out.println("2 areg constuctor called for Engine");
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}

}
