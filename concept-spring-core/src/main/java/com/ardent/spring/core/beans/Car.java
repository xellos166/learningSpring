package com.ardent.spring.core.beans;

public class Car {
	private String modelname;
	private String color;
	private Engine engine;

	@Override
	public String toString() {
		return "Car [modelname=" + modelname + ", color=" + color + ", engine=" + engine + "]";
	}

	public Car() {
		System.out.println("0 areg constuctor called for Car");
	}

	public Car(String modelname, String color, Engine engine) {
		this.modelname = modelname;
		this.color = color;
		this.engine = engine;
		System.out.println("3 areg constuctor called for Car");
	}

	public String getModelname() {

		return modelname;
	}

	public void setModelname(String modelname) {
		System.out.println("setModelname called");
		this.modelname = modelname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		System.out.println("setColor called");
		this.color = color;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		System.out.println("setEngine called");
		this.engine = engine;
	}

}
