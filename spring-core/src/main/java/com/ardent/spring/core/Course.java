package com.ardent.spring.core;

public class Course {

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + "]";
	}

	private String courseName;
	private int courseId;

	public Course(String courseName, int courseId) {
		super();
		System.out.println("Course created by 2 areg constructor");
		this.courseName = courseName;
		this.courseId = courseId;
	}

	public Course() {

	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
