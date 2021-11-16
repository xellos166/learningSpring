package com.infy.springboot.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMP_DETAILS")
public class Employee implements Serializable {

	// private static final long serialVersionUID = 8848337779617076670L;

	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Integer id;

	@Column(name = "EMP_NAME")
	private String name;

	@Column(name = "EMP_ROLE")
	private String role;

	@Column(name = "EMP_DEPT")
	private String dept;

	@Column(name = "EMP_SALARY")
	private Double salary;

}
