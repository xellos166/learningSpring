package com.ardent.spring.boot.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequest implements Serializable {

	private static final long serialVersionUID = 2797216234950232838L;

	@NotBlank(message = "posttext can not be null")
	private String postText;

	@Pattern(regexp = "^[a-zA-Z]*$", message = "input must match onlt A-Z and a-z")
	private String author;

	private String reaction;
}
