package com.ardent.spring.boot.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6171756965033551016L;

	private String message;

	private String errorCode;

}
