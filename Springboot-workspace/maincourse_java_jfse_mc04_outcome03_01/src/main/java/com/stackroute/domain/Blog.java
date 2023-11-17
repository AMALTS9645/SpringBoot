package com.stackroute.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* Add Annotation to declare this class as a JPA Entity */
@Entity
@Table(name = "blog")
public class Blog {
    /*Add Annotation to declare this field as a Unique Identifier */
	@Id
	@Column(unique = true)
    private int blogId;
    private String blogTitle;
    private String authorName;
    private String blogContent;

    /* Generate no-arg and parametrized consructor */
    
    
    
    
    public Blog(int blogId, String blogTitle, String authorName, String blogContent) {
    	super();
    	this.blogId = blogId;
    	this.blogTitle = blogTitle;
    	this.authorName = authorName;
    	this.blogContent = blogContent;
    }
    
    public Blog() {
		super();
	}

    public int getBlogId() {
        return blogId;
    }


	public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
