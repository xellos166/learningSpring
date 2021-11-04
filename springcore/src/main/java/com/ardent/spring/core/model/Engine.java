package com.ardent.spring.core.model;

public class Engine {

	private EngineType type;

	public Engine(EngineType type) {

		System.out.println("Engine created from constructor");
		this.type = type;
	}

	public void start() {
		System.out.println("Enging starting...");
	}

}
