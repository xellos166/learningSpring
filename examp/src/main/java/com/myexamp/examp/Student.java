package com.myexamp.examp;

public class Student {
	private int roll;
	private String name;
	private Address addr;

	public Student(int roll, String name, Address addr) {
		super();
		System.out.println("3 arg contructor called in Student");
		this.roll = roll;
		this.name = name;
		this.addr = addr;
	}

	public Student() {
		System.out.println("0 arg contructor called in Student");

	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		System.out.println("Roll is set");
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Name is set");
		this.name = name;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		System.out.println("Address is set");
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", addr=" + addr + "]";
	}

}
