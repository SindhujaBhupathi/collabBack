package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Job;

public interface JobDAO {
	
	boolean saveJob(Job job);
	List<Job> getAllJobs();
	Job getJobById(int id);
	
}
