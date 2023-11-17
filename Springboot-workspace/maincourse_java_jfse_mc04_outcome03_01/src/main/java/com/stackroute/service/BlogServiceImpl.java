package com.stackroute.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogRepository repo;

	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return repo.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return (List<Blog>) repo.findAll();
	}

	@Override
	public Blog getBlogById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Blog deleteBlog(int id) {
		// TODO Auto-generated method stub
		Optional<Blog> find_blog = repo.findById(id);
        if(find_blog.isPresent()) {
            repo.deleteById(id);
            return repo.findById(id).get();
        }
        return null;

	}

	@Override
	public Blog updateBlog(Blog blog) {
		Optional<Blog> find_blog = repo.findById(blog.getBlogId());
        if(find_blog.isPresent()){
            repo.save(blog);
            return repo.findById(blog.getBlogId()).get();
        }
        return null;
	}

}
