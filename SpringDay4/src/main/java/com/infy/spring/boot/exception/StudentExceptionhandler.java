package com.infy.spring.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infy.spring.boot.model.response.APIErrorResponse;
import com.infy.spring.boot.model.response.APIResponse;

@ControllerAdvice
@RestController
public class StudentExceptionhandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse> handleAllException(Exception ex, WebRequest request) {
		APIResponse response = new APIResponse(false, null, "Some thing went wrong",
				new APIErrorResponse("SA_002", ex.getLocalizedMessage()));
		return new ResponseEntity<APIResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
