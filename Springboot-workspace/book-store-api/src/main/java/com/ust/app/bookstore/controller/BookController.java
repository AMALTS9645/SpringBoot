package com.ust.app.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.app.bookstore.model.Book;
import com.ust.app.bookstore.service.BookService;

@RestController
@RequestMapping("/book/api")
public class BookController {
	
	@Autowired
	private BookService service;

	@GetMapping
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping
	public Book createBook(@RequestBody @Valid Book book){
		return service.createBook(book);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") int id){
		return service.getBookById(id);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable("id") int id, @RequestBody @Valid Book book){
		return service.updateBook(id,book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable("id") int id) {
		service.deleteBook(id);
	}
	
	
	
}
