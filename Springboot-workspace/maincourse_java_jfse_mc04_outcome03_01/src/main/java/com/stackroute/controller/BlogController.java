package com.stackroute.controller;

import java.util.List;

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

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1")
public class BlogController {

	/* Provide implementation code for these methods */
	private BlogService service;

	@Autowired
	public BlogController(BlogService blogService) {
		this.service = blogService;
	}

	/* This method saves a blog and returns the blog object */
	@PostMapping("/blog")
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
		Blog savedBlog = service.saveBlog(blog);
		return new ResponseEntity<Blog>(savedBlog, HttpStatus.CREATED);
	}

	/* This method fetches all blogs and returns the list of all blogs */
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		return new ResponseEntity<List<Blog>>((List<Blog>) service.getAllBlogs(), HttpStatus.OK);

	}

	/* This method fetches a blog by its id and returns the respective blog */
	@GetMapping("blog/{blogId}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId) {
		return new ResponseEntity<Blog>(service.getBlogById(blogId), HttpStatus.FOUND);
	}

	/* This method deletes a blog by its id and returns the deleted blog object */
	@DeleteMapping("blog/{blogId}")
	public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable("blogId") int blogId) {
		return new ResponseEntity<Blog>(service.deleteBlog(blogId), HttpStatus.OK);
	}

	/* This method updates the blog content and returns the updated blog object */
	@PutMapping("blog")
	public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
		Blog updatedBlog = service.updateBlog(blog);
		return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
	}
}