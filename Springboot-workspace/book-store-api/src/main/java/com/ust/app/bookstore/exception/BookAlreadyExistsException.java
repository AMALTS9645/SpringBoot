package com.ust.app.bookstore.exception;

public class BookAlreadyExistsException extends RuntimeException{
	public BookAlreadyExistsException(String message) {
		super(message);
	}
}
