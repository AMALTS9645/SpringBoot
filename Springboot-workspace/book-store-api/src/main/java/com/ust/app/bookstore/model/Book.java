package com.ust.app.bookstore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_store")
public class Book {
	@Id
	private int id;
	
	
	@Column(name = "title",length = 100,nullable=false)
	@NotBlank(message = "Title cannot be empty")
	@Size(max = 100,message = "Title should not exceed 100 characters")
	private String title;
	
	
	@NotBlank(message = "Author name cannot be empty")
	@Size(max = 200,message = "Author name cannot exceed 200 characters")
	private String author;
	
	
	@Column(unique = true)
	@Pattern(regexp = "^(\\d{10,14})" ,message = "ISBN should be a 10-13 digit number")
	private String isbn;
	
	
	@Pattern(regexp = "^\\d{4}$",message = "publication Year must be a 4 digit number")
	private String publicationYear;
	
	
	@Positive(message = "The price should be a positive decimal value.")
    @DecimalMin(value = "0.01", message = "Price must be a positive decimal value")
	private double price;
}
