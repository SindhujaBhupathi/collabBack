package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.dao.JobDAO;
import com.collaboration.model.Job; 


@Service
public class JobServiceImpl implements JobService{
	
    @Autowired
    private JobDAO jobDAO;
	
	public boolean addJobs(Job job) {
		return jobDAO.addJobs(job);
	}

	public boolean updateJobs(Job job) {
		return jobDAO.updateJobs(job);
	}

	public boolean deleteJobs(Job job) {
		return jobDAO.deleteJobs(job);
	}

	public Job getJobs(int jobId) {
		return jobDAO.getJobDetail(jobId);
	}

	public List<Job> getAllJobs() {
		return jobDAO.getAllJobDetails();
	}

}
