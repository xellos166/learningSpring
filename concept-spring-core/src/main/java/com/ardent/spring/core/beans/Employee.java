package com.ardent.spring.core.beans;

public class Employee {

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + "]";
	}

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee() {

	}
}
