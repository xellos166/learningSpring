package com.ardent.spring.core.model;

public class TataMotors {

	private Engine engine;

	public TataMotors(Engine engine) {
		System.out.println("Creating car from constructor");
		this.engine = engine;
	}

	public void start() {
		engine.start();
		System.out.println("Tata car starting...");
	}

	/*
	 * @Override public void stop() { System.out.println("Tata Car Stoper....");
	 * 
	 * }
	 */

}
