package com.infy.spring.boot.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIErrorResponse {
	private String errorCode;
	private String errorMessage;

}
