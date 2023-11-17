package com.bookstoreapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_store")
public class Book {

    @Id
    private int id;

    @NotBlank(message = "title cannot be blank")
    @Size(max = 100, message = "author name should not exceed 100 characters")
    private String title;

    @NotBlank(message = "Author name cannot be empty")
    @Size(max = 200, message = "author name should not exceed 200 characters")
    private String author;

    // @Length(min = 4,max = 4,message = "year must be 4 digit long")
    @Max(value = 9999)
    @Min(value = 1000)
    private int publicationYear;

    @Column(unique = true)
    // @Pattern(regexp = "^(//d{10,13})$",message = "isbn should be 10-13 digits
    // long")
    @Max(value = 9999999999999L,message = "isbn should be 10-13 digits")
    @Min(value = 1000000000,message = "isbn should be 10-13 digits")
    private long isbn;

    @Positive(message = "The price should be a positive decimal value.")
    @DecimalMin(value = "0.01", message = "Price must be a positive decimal value")
    private double price;

}
