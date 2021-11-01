package com.ardent.spring.core.model;

public class TataMotors implements Car {

	@Override
	public void start() {
		System.out.println("Tata car starting...");

	}

	@Override
	public void stop() {
		System.out.println("Tata Car Stoper....");

	}

}
