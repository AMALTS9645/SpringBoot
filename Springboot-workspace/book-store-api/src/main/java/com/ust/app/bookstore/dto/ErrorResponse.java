package com.ust.app.bookstore.dto;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private LocalDate timeStamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
