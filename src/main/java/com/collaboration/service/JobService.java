package com.collaboration.service;

import java.util.List;

import com.collaboration.model.Job;

public interface JobService {

    public boolean addJobs(Job job);
	
	public boolean updateJobs(Job job);
	
	public boolean deleteJobs(Job job);
	
	public Job getJobs(int jobId);
	
	public List<Job> getAllJobs();
}
