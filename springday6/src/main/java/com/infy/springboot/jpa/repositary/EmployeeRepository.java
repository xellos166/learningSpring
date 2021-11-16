package com.infy.springboot.jpa.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.springboot.jpa.model.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
