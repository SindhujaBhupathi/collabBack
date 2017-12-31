package com.collaboration.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.model.ErrorClass;
import com.collaboration.model.Job;
import com.collaboration.model.User;
import com.collaboration.service.JobService;
import com.collaboration.service.UserService;

@RestController
public class JobRESTController {
    @Autowired
	UserService userService;
    @Autowired
    JobService jobservice;
    
    @RequestMapping(value="/addJob",method=RequestMethod.POST)
	public ResponseEntity<?> addJob(@RequestBody Job job,HttpSession session){
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId==null){
			return new ResponseEntity<ErrorClass>(new ErrorClass(7,"User session details not found"),HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.getUser(userId);
		
		if(!user.getRole().equals("ADMIN")){
			
			return new ResponseEntity<ErrorClass>(new ErrorClass(8,"Access Denied"),HttpStatus.UNAUTHORIZED);
		}
		
		job.setPostedOn(new Date());
		
		if(jobservice.addJobs(job)){
			
			return new ResponseEntity<Job>(job,HttpStatus.OK);
			
		}else{
			
			return new ResponseEntity<ErrorClass>(new ErrorClass(31,"Unable to save Job details"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
		
	
	@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId==null){
			return new ResponseEntity<ErrorClass>(new ErrorClass(7,"User session details not found"),HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.getUser(userId);
		
		List<Job> jobList = jobservice.getAllJobs();
		
		if(jobList!=null){
			
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
			
		}else{
			
			return new ResponseEntity<ErrorClass>(new ErrorClass(31,"Unable to fetch Job details"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}	
	
	@RequestMapping(value="/getJob/{jobId}",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(@PathVariable("jobId") int jobId,HttpSession session){
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId==null){
			return new ResponseEntity<ErrorClass>(new ErrorClass(7,"User session details not found"),HttpStatus.UNAUTHORIZED);
		}
		
		User user = userService.getUser(userId);
		
		Job job = jobservice.getJobs(jobId);
		
		if(job!=null){
			
			return new ResponseEntity<Job>(job,HttpStatus.OK);
			
		}else{
			
			return new ResponseEntity<ErrorClass>(new ErrorClass(31,"Unable to fetch Job details"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
}
