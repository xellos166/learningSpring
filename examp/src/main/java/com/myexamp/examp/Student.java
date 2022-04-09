package com.myexamp.examp;

public class Student {
	private int roll;
	private String name;
	private Address addr;

	public Student(int roll, String name, Address addr) {
		super();
		this.roll = roll;
		this.name = name;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", addr=" + addr + "]";
	}

}
