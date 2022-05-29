package com.ardent.spring.core.beans;

public class Valve {

	private Integer diameter;
	private String metal;

	public Integer getDiameter() {
		return diameter;
	}

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}

	public Valve() {

	}

	public Valve(Integer diameter, String metal) {

		this.diameter = diameter;
		this.metal = metal;
		System.out.println("2 areg constuctor called for Valve");
	}

	@Override
	public String toString() {
		return "Valve [diameter=" + diameter + ", metal=" + metal + "]";
	}

}
