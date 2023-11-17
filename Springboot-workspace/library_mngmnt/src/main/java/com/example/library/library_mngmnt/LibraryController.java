package com.example.library.library_mngmnt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    @Autowired
    LibraryRepository repo;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(repo.save(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id){
        Optional<Book> book = repo.findById(id);
        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        }else if(!book.isPresent()){
            throw new BookNotFoundException("book not found");
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search")
    public ResponseEntity<?> getBookByName(@RequestParam("name") String name){
        Optional<Book> book = repo.findByName(name);
        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<List<Book>> getBooksWithIds(@PathVariable("from") long from, @PathVariable("to") long to){
        return ResponseEntity.ok(repo.findByIdRange(from,to));
    }
    
}
