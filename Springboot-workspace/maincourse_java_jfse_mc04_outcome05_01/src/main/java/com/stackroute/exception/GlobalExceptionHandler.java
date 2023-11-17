package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BlogNotFoundException.class)
	public String handleCustomerAlreadyExistsException(BlogNotFoundException ex) {
		return ex.getMessage();
	}

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(BlogAlreadyExistsException.class)
	public String handleCustomerAlreadyExistsException(BlogAlreadyExistsException ex) {
		return ex.getMessage();
	}

}
