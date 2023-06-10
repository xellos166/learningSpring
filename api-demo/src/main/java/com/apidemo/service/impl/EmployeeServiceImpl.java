package com.apidemo.service.impl;

import com.apidemo.model.Employee;
import com.apidemo.repository.EmployeeRepository;
import com.apidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Override
    public Long createEmployee(Employee c) {
        Employee savedEmployee= repository.save(c);
        return c.getId();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee= repository.findById(id);
        if(employee.isPresent())
            return employee.get();
        else
            return null;
    }

    @Override
    public Employee editEmployeeById(Long id, Employee employee) {
        Optional<Employee> presentEmployee= repository.findById(id);
        if(presentEmployee.isPresent()) {
            Employee existingEmployee=presentEmployee.get();
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setName(employee.getName());
            repository.save(existingEmployee);
            return existingEmployee;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Optional<Employee> employee= repository.findById(id);
        if(employee.isPresent()) {
            repository.deleteById(id);
            return employee.get();
        }
        else
            return null;
    }
}
