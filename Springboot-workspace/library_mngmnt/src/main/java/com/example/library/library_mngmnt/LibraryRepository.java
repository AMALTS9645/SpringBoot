package com.example.library.library_mngmnt;

import java.util.Optional;

import javax.management.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface LibraryRepository extends JpaRepository<Book,Long>{

    public Optional<Book> findByName(String name);
    
    @org.springframework.data.jpa.repository.Query(value = "from Book where id between :from and :to")
    public List<Book> findByIdRange(Long from, Long to);
}
