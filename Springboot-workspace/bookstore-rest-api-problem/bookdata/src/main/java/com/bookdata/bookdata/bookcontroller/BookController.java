package com.bookdata.bookdata.bookcontroller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookdata.bookdata.bookRepository.BookRepository;
import com.bookdata.bookdata.model.Book;

class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository repo;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity((List<Book>)repo.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<Book>(repo.save(book), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        return new ResponseEntity<Book>(repo.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(repo.save(book));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        repo.deleteById(id);
    }

}
