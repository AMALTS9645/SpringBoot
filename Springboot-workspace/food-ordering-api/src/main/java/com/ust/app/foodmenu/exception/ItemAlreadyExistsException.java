package com.ust.app.foodmenu.exception;

public class ItemAlreadyExistsException extends RuntimeException{
	public ItemAlreadyExistsException(String message) {
		super(message);
	}

}
