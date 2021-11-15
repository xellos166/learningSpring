package com.infy.spring.boot.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@NotNull(message = "Id can not be null")
	private Integer id;

	@Min(value = 3)
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String name;

	@Email
	private String email;

	@NotEmpty
	private String course;

}
