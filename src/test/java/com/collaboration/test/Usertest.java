package com.collaboration.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import static org.junit.Assert.*;
import com.collaboration.config.DBconfig;
import com.collaboration.dao.Userdao;
import com.collaboration.model.User;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@Ignore
@ComponentScan("com.collaboration")
public class Usertest {
	static Userdao  userdao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBconfig.class);
		context.scan("com.collaboration");
		context.refresh();

		userdao=(Userdao)context.getBean("userdao");
	}
	@Ignore
	@Test
	public void addUserTest()
	{
		User user=new User();
		//user.setUser_id(1);
		user.setUserName("rishi");
		user.setFirstName("rishitha");
		user.setLastName("bhupathi");
		user.setContact("9849411135");
		user.setEmail("rishi@gmail.com");
		user.setPassword("123");
		user.setRole("Student");
		assertTrue("Problem in Inserting user", userdao.saveOrUpdate(user));	}
	
}
