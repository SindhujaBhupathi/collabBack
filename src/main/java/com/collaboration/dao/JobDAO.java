package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Job;

public interface JobDAO {


	public boolean addJobs(Job job);
	
	public boolean updateJobs(Job job);
	
	public boolean deleteJobs(Job job);
	
	public Job getJobDetail(int jobId);
	
	public List<Job> getAllJobDetails();
	
}
