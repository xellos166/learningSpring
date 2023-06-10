package com.apidemo.service;

import com.apidemo.model.Employee;

import java.util.List;

public interface EmployeeService {
   Long createEmployee(Employee employee);
   Employee getEmployeeById(Long id);

   Employee editEmployeeById(Long id,Employee employee);
   List<Employee> getAllEmployees();

   Employee deleteEmployee(Long id);
}
