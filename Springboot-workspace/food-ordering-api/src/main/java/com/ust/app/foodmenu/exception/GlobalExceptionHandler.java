package com.ust.app.foodmenu.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.app.foodmenu.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidCategoryException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCategoryException(InvalidCategoryException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(response);
	}

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), status.value(), ex.getMessage(),
				status.getReasonPhrase(), request.getRequestURI());

		return ResponseEntity.status(status).body(response);
	}

	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleItemAlreadyExistsException(ItemAlreadyExistsException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), status.value(), ex.getMessage(),
				status.getReasonPhrase(), request.getRequestURI());
		return ResponseEntity.status(status).body(response);

	}

}
