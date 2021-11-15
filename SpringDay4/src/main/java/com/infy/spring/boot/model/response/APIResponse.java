package com.infy.spring.boot.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

	private boolean success;
	private Object data;
	private String message;
	private APIErrorResponse error;

}
