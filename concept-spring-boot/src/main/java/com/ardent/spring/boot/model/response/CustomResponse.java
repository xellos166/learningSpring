package com.ardent.spring.boot.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse implements Serializable {

	private static final long serialVersionUID = 287204135509699212L;
	private Object data;
	private String message;
}
