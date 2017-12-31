/*package com.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import static org.junit.Assert.*;
import com.collaboration.config.DBconfig;
import com.collaboration.dao.UserDAO;
import com.collaboration.model.User;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@ComponentScan("com.collaboration")
public class UserTest {
	static UserDAO  userDAO;
	


	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBconfig.class);
		context.scan("com.collaboration");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userdao");
	}
	
	@Test
	public void addUserTest()
	{
		User user=new User();
		//user.setUser_id(1);
		user.setUserName("mouni");
		user.setFirstName("mouni");
		user.setLastName("devi");
		user.setContact("9584555800");
		user.setEmail("mouni@gmail.com");
		user.setPassword("123");
		user.setRole("Student");
		assertTrue("Problem in Inserting user", userDAO.saveOrUpdate(user));	}
	
}
*/