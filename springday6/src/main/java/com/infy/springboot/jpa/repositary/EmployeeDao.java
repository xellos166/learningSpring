package com.infy.springboot.jpa.repositary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infy.springboot.jpa.model.Employee;

@Repository
@Transactional
//This annotation indicates that this object will be used for database interaction. Spring framework
//will create the object at the time of starting of the application.
public class EmployeeDao {
	@PersistenceContext
	// The above annotation will instantiate entity manager. EntityManager is an
	// interface provided by Spring Data Jpa and it is used to manage entities, like
	// here we have only on entity called Employee.
	private EntityManager entityManager;

//	EmployeeDao() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.infy.springboot.jpa.model");
//		entityManager = emf.createEntityManager();
//	}
	// We can create entity manager by the above method also,Since we are
	// responsible for creating EntityManager instances, it's also our
	// responsibility to close them. Therefore, we should close each EntityManager
	// when we're done using them.
	public Integer createEmployee(Employee employee) {
		entityManager.persist(employee);
		employee.setRole("Tester");// this state is called persistance context state, since role has been set after
									// persist method is called persistance-context
		return employee.getId();
	}

}
