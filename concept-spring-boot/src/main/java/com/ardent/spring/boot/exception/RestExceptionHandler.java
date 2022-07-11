package com.ardent.spring.boot.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ardent.spring.boot.model.response.ApiError;
import com.ardent.spring.boot.model.response.CustomResponse;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomResponse> handleAllEception(Exception ex) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		CustomResponse c = new CustomResponse(null, "Exception occured ",
				new ApiError(ex.getLocalizedMessage(), status.value() + ""));
		return new ResponseEntity<>(c, status);
	}

	@ExceptionHandler(value = DataAccessException.class)
	public ResponseEntity<CustomResponse> handleAllDBEception(Exception ex) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		CustomResponse c = new CustomResponse(null, "Exception occured ",
				new ApiError(ex.getLocalizedMessage(), status.value() + ""));
		return new ResponseEntity<>(c, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomResponse c = new CustomResponse(null, ex.getObjectName() + "Exception occured ",
				new ApiError(ex.getMessage(), status.value() + ""));
		return new ResponseEntity<>(c, status);
	}
}
