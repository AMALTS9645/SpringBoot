package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookstoreService.getAllBooks();
    }


   @PostMapping
    public Book saveBook(@RequestBody @Valid Book book) {
        return bookstoreService.saveBook(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Book updateBook(@PathVariable("id") int id,@RequestBody @Valid Book book) {
        return bookstoreService.updateBook(id, book);
    }

   @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookstoreService.deleteBook(id);
    }

   
   @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
       return bookstoreService.getBookById(id);
    }




}
