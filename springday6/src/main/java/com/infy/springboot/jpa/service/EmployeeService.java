package com.infy.springboot.jpa.service;

import java.util.List;

import com.infy.springboot.jpa.model.Employee;

public interface EmployeeService {
	public String addEmployee(Employee employee);

	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployee();

	public String deleteEmployee(Integer id);

}
