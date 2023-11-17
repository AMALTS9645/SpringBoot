package com.ust.app.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.app.bookstore.exception.BookAlreadyExistsException;
import com.ust.app.bookstore.exception.BookNotFoundException;
import com.ust.app.bookstore.model.Book;
import com.ust.app.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repo;

	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> book = repo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new BookNotFoundException("Book with id : " + id + " Not found");
		}
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		Optional<Book> book_p = repo.findById(book.getId());
		if (book_p.isPresent()) {
			throw new BookAlreadyExistsException("Book already Exists");
		}
		return repo.save(book);
	}

	@Override
	public Book updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		Optional<Book> book_p = repo.findById(id);
		Book b = null;
		if (book_p.isPresent()) {
			b = repo.save(book);
		} else {
			throw new BookNotFoundException("Book with id : " + id + " Not found");
		}
		return b;

	}

	@Override
	public void deleteBook(int id) {
		Optional<Book> book_p = repo.findById(id);
		if (book_p.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new BookNotFoundException("Book with id : " + id + " Not found");
		}

	}

}
