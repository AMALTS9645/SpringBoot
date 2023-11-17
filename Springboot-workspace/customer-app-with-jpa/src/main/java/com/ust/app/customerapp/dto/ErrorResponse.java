package com.ust.app.customerapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private LocalDateTime timeStamp;
	private int status;
	private String error;
	private String message;
	private String path;
	
}
