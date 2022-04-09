package com.ardent.spring.core.car;

public class Engineprovider {
	
	public static Engine getEngine() {
		return new Engine(2, "Pertrol", 1200);
	}

}
