package com.bookdata.bookdata.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookdata.bookdata.model.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{

}