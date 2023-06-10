package com.apidemo.controller;

import com.apidemo.model.Employee;
import com.apidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    Long createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable(name = "id" ,required = true) Long id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping ("/employee/{id}")
    Employee updateEmployeeById(@PathVariable(name = "id" ,required = true) Long id
            ,@RequestBody Employee employee){
        return employeeService.editEmployeeById(id,employee);
    }
    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping ("/employee/{id}")
    Employee deleteEmployee(@PathVariable(name = "id" ,required = true) Long id){
        return employeeService.deleteEmployee(id);
    }
}
