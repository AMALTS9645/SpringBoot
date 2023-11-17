package com.ust.app.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.app.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
