package com.ust.app.bookstore.service;

import java.util.List;

import com.ust.app.bookstore.model.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public Book createBook(Book book);
	public Book updateBook(int id, Book book);
	public void deleteBook(int id);
	
}
