/*package com.collaboration.test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.collaboration.model.BlogPost;
import com.collaboration.service.BlogPostService;
@ComponentScan("com.collaboration")
public class BlogTest {
	@Autowired
	private static BlogPostService blogPostService;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		
		blogPostService = (BlogPostService) context.getBean("blogPostService");
		
	}
	
	@Test
	public void createBlogTest(){
		
		Blog blog = new Blog();
		
		blog.setBlogTitle("Angular JS");
		blog.setBlogContent("Angular Js Tutorial for Client side scripting.");
		blog.setStatus("PENDING");
		blog.setCreatedDate(new Date());
		blog.setUserId(46);
		
		assertTrue("Problem in storing Blog details",blogService.addBlog(blog));
		
	}
}
*/