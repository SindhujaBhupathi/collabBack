package com.collaboration.service;

import java.util.List;

import com.collaboration.model.BlogComment;
import com.collaboration.model.BlogPost;

public interface BlogPostService {
	void saveBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogs(int approved);//values = 0 / 1
	BlogPost getBlogById(int id);
	void updateBlogPost(BlogPost blogPost,String rejectionReason);
}
