package com.collaboration.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.collaboration.config.DBconfig;
import com.collaboration.dao.JobDAO;
import com.collaboration.model.Job;
import com.collaboration.service.JobService;


@ComponentScan("com.collaboration")
public class JobTest {
	
	 
	static JobDAO jobDAO;
	
	
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DBconfig.class);
		context.scan("com.collaboration");
		context.refresh();
		
		jobDAO = (JobDAO) context.getBean("jobDAO");
	}

	@Test
	public void createJobsTest(){
		
		Job job = new Job();
		job.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		job.setJobTitle("Software Engineer");
		job.setSkillsRequired("B.Tech");
		job.setCompanyName("XYZ Pvt Ltd");
		job.setLocation("Hyderabad");
		job.setYrsOfExp("2+ Yrs");
		job.setSalary("250000");
		job.setPostedOn(new Date());
		
		assertTrue("Problem in storing Job details",jobDAO.addJobs(job));
	}

}
