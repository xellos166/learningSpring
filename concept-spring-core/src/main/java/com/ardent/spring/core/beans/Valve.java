package com.ardent.spring.core.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Valve implements InitializingBean, DisposableBean {

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

	@Override
	public void destroy() throws Exception {
		System.out.println("this bean is going to be destroyed");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("This bean has just been initialized ...");

	}

}
