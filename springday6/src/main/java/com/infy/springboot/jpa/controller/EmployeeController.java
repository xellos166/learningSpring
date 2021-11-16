package com.infy.springboot.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springboot.jpa.model.Employee;
import com.infy.springboot.jpa.service.EmployeeService;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/employee/add")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@DeleteMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Integer id) {
		return employeeService.deleteEmployee(id);
	}
}
