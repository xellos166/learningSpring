package com.infy.spring.boot.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.spring.boot.model.Student;
import com.infy.spring.boot.model.response.APIErrorResponse;
import com.infy.spring.boot.model.response.APIResponse;
import com.infy.spring.boot.service.StudentService;

@RestController
@Validated
public class StudentController {

	// Logger logger= LogFactory.getLog(t);
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		System.out.println("Inside constructor");
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public ResponseEntity<APIResponse> getStudents() {
		List<Student> data = studentService.getStudents();
		String responseMsg = null;
		if (data != null) {
			responseMsg = "List of students successfully retrieved";
		} else {
			responseMsg = "No Student found";
		}
		APIResponse response = new APIResponse(true, data, responseMsg, null);
		return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<APIResponse> getStudent(
			@Valid @PathVariable(name = "id", required = true) /*@Max(value = 4, message = "more than 2 digit is not allowed") */Integer id) {
		Student data = studentService.getStudentById(id);
		String responseMsg = null;
		APIResponse response = null;
		HttpStatus status = null;
		if (data != null) {
			responseMsg = "Student retreived successfully";
			response = new APIResponse(true, data, responseMsg, null);
			status = HttpStatus.OK;
		} else {
			responseMsg = "No student found";
			response = new APIResponse(false, data, responseMsg,
					new APIErrorResponse("SA_001", "Student not available"));
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<APIResponse>(response, status);

	}

	@PostMapping("/student/create")
	public String addStudent(@Valid @RequestBody Student student) {
		return studentService.addStudent(student);

	}

	@DeleteMapping("/student")
	public String deleteStudent(@RequestParam(name = "id", /* required = true, */ defaultValue = "10") Integer id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping("/student")
	public Student editStudent(Student student) {
		return studentService.editStudent(student);
	}

}
