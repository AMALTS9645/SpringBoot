package com.ust.app.bookstore.exception;

public class BookNotFoundException  extends RuntimeException{
	public BookNotFoundException(String message) {
		super(message);
	}
}
