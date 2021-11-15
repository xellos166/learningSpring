package com.infy.spring.boot.service;

import java.util.List;

import com.infy.spring.boot.model.Student;

public interface StudentService {
	public List<Student> getStudents();
	public Student getStudentById(Integer id);
	public String addStudent(Student student);
	public String deleteStudent(Integer id);
	public Student editStudent(Student student);


}
