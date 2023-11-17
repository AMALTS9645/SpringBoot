package com.ust.app.bookstore.exception;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.app.bookstore.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorResponse response = new ErrorResponse(LocalDate.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());

		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	
	
	

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(BookAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleBookAlreadyExistsException(BookAlreadyExistsException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		ErrorResponse response = new ErrorResponse(LocalDate.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<ErrorResponse>(response, status);
	}

	
	
	
	
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorResponse response = new ErrorResponse(LocalDate.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<ErrorResponse>(response,status);
	}
	
	
	
	
	
	
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorResponse response = new ErrorResponse(LocalDate.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<ErrorResponse>(response,status);
	}
}
