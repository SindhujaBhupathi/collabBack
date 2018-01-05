package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.dao.BlogPostDAO;
import com.collaboration.model.BlogComment;
import com.collaboration.model.BlogPost;

@Service
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired
private BlogPostDAO blogPostDAO;
	

	public List<BlogPost> getBlogs(int approved) {
		
		return blogPostDAO.getBlogs(approved);
	}

	public BlogPost getBlogById(int id) {
		
		return blogPostDAO.getBlogById(id);
	}

	public void updateBlogPost(BlogPost blogPost, String rejectionReason) {
		// TODO Auto-generated method stub
		
	}

	public void saveBlogPost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
