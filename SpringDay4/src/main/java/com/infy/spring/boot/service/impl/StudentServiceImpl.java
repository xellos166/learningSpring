package com.infy.spring.boot.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infy.spring.boot.model.Student;
import com.infy.spring.boot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	public static List<Student> studentContainer = // new ArrayList();
			Arrays.asList(new Student(10, "Arvind", "arvind@gmail.com", "CS"));

	static {
		// studentContainer.add(new Student(10, "Arvind", "arvind@gmail.com", "CS"));
	}

	@Override
	public List<Student> getStudents() {
		return studentContainer;
	}

	@Override
	public Student getStudentById(Integer id) {
		// Optional<Student> s = studentContainer.stream().filter(st ->
		// st.getId().equals(id)).findFirst();
		Student res = null;
		for (Student s : studentContainer) {
			if (s.getId().equals(id)) {
				res = s;
			}
		}
		return res;
	}

	@Override
	public String addStudent(Student student) {
		boolean result = studentContainer.add(student);
		return result ? "Succesfully added student " : "Problem occured during student creation";
	}

	@Override
	public String deleteStudent(Integer id) {
		boolean result = false;
		Student studentToberemoved = null;
		for (Student s : studentContainer) {
			if (s.getId().equals(id)) {
				studentToberemoved = s;
				break;
			}
		}
		if (studentToberemoved != null) {
			result = studentContainer.remove(studentToberemoved);
		}
		return result ? "Deleted successfully" : "Problem occured during deletion";
	}

	@Override
	public Student editStudent(Student student) {
		Student modifiedStudent = null;
		for (Student s : studentContainer) {
			if (s.getId().equals(student.getId())) {
				s.setName(student.getName());
				s.setEmail(student.getEmail());
				s.setCourse(student.getCourse());
				modifiedStudent = s;
			}

		}
		return modifiedStudent;
	}

}
