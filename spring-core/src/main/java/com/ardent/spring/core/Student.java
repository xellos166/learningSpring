package com.ardent.spring.core;

public class Student {
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", roll=" + roll + ", course=" + course + "]";
	}

	private String studentName;
	private int roll;
	//dependency
	private Course course;

	public Student(String studentName, int roll, Course course) {
		super();
		System.out.println("3 arg constructor called");
		this.studentName = studentName;
		this.roll = roll;
		this.course = course;
	}
	
	public Student(String studentName, int roll) {
		super();
		System.out.println("2 arg constructor called");
		this.studentName = studentName;
		this.roll = roll;
		
	}


	public Student() {
		System.out.println("0 arg constructor called");

	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public Course getCourse() {
		
		return course;
	}

	public void setCourse(Course course) {
		System.out.println("setCourse called");
		this.course = course;
	}

}
