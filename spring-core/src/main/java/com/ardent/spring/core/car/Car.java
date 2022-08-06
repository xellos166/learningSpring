package com.ardent.spring.core.car;

public class Car {

	private String color;
	private String modelName;
	// Inline initialization
	private Engine engine = Engineprovider.getEngine();
	// new Engine(2, "Petrol", 1200);//<--1st Way of managing dependency

	@Override
	public String toString() {
		return "Car [color=" + color + ", modelName=" + modelName + ", engine=" + engine + ", manufacturar="
				+ manufacturar + "]";
	}

	// dependency
	private String manufacturar;

	public Car(String color, String modelName, Engine engine, String manufacturar) {
		super();
		this.color = color;
		this.modelName = modelName;
		this.engine = engine;
		this.manufacturar = manufacturar;
	}

	public Car(String color, String modelName, String manufacturar) {
		super();
		this.color = color;
		this.modelName = modelName;
		this.manufacturar = manufacturar;
	}

}
