package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/* This is ServiceImplementation Class which should implement BlogService Interface and override all the implemented methods.
 * Handle suitable exceptions for all the implemented methods*/

import com.stackroute.domain.Blog;
import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogRepository repo;

	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		Optional<Blog> blog1 = repo.findById(blog.getBlogId());
		Blog b = null;
		if (!blog1.isPresent()) {
			b = repo.save(blog);
		} else {

			throw new BlogAlreadyExistsException();
		}
		return b;

	}

	@Override
	public List<Blog> getAllBlogs() {
		return (List<Blog>) repo.findAll();
	}

	@Override
	public Blog getBlogById(int id) {
		Optional<Blog> find_blog = repo.findById(id);
		if (find_blog.isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new BlogNotFoundException();
		}

	}

	@Override
	public Blog deleteBlog(int id) {
		// TODO Auto-generated method stub
		Optional<Blog> find_blog = repo.findById(id);
        if(find_blog.isPresent()) {
            repo.deleteById(id);
            Optional<Blog> b = repo.findById(id);
            if(!b.isPresent()) {
            	return find_blog.get();
            }
        }else  {
        	throw new BlogNotFoundException();
        }
        return find_blog.get();
	}

	@Override
	public Blog updateBlog(Blog blog) {
		Optional<Blog> find_blog = repo.findById(blog.getBlogId());
		Blog b = null;
		if (repo.existsById(blog.getBlogId())) {
			b = repo.save(blog);
		} else {
			throw new BlogNotFoundException();
		}
		return b;
	}

}
