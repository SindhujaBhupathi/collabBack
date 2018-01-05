/*package com.collaboration.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.collaboration.config.DBconfig;
import com.collaboration.dao.JobDAO;
import com.collaboration.dao.UserDAO;
import com.collaboration.model.Job;


@ComponentScan("com.collaboration")
public class JobTest {
	
	static UserDAO  userDAO;
	static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBconfig.class);
		context.scan("com.collaboration");
		context.refresh();
		context.close();
		jobDAO=(JobDAO)context.getBean("jobdao");
	}
	
	@Test
	public void createJobsTest(){
		
		Job Job = new Job();
		Job.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		Job.setJobTitle("Software Engineer");
		Job.setSkillsRequired("B.Tech");
		Job.setCompanyName("XYZ Pvt Ltd");
		Job.setLocation("Hyderabad");
		Job.setYrsOfExp("2+ Yrs");
		Job.setSalary("250000");
		Job.setPostedOn(new Date());
		assertTrue("Problem in Inserting job", jobDAO.saveJob(Job));
		
		
	}

}
*/