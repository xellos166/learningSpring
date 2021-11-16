package com.infy.springboot.jpa.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.infy.springboot.jpa.model.Employee;
import com.infy.springboot.jpa.repositary.EmployeeRepository;
import com.infy.springboot.jpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//	private final EmployeeDao employeeDao;
//
//	public EmployeeServiceImpl(EmployeeDao employeeDao) {
//		super();
//		this.employeeDao = employeeDao;
//	}
	private final EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public String addEmployee(Employee employee) {
		Employee result = employeeRepo.save(employee);// save method is defined by JPA REPOSITORY implementation.

//		Integer result = employeeDao.createEmployee(employee);
		return "Employee added with id " + result.getId();
	}

	@Override
	public Employee getEmployeeById(Integer id) {

		// return
		// fetch a proxy object lazily -->Employee r=employeeRepo.getById(id);
		// r.getDept() <-- this line will hit the db
		// Basically getOne is a lazy load operation. Thus you get only a reference (a
		// proxy) to the entity. That means no DB access is actually made. Only when you
		// call it's properties then it will query the DB. findByID does the call
		// 'eagerly'/immediately when you call it, thus you have the actual entity fully
		// populated.s
		return employeeRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepo.findAll();// findAll is defined by JPA Repository implementation
	}

	@Override
	public String deleteEmployee(Integer id) {
		String msg = null;
		employeeRepo.deleteById(id);
		Optional<Employee> result = employeeRepo.findById(id);
		if (result.isEmpty()) {
			msg = "Employee has been successfully deleted";
		} else {
			msg = "Something went wrong";
		}
		return msg;

	}

}
