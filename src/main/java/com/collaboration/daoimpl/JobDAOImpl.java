package com.collaboration.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import com.collaboration.dao.JobDAO;
import com.collaboration.model.Job;

@Repository
public class JobDAOImpl  implements JobDAO{
	
	Logger Logger=LoggerFactory.getLogger(JobDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addJobs(Job job) {
		try
		{
		    sessionFactory.getCurrentSession().save(job);
			return true;
		}catch(Exception e){
			System.out.println("Exception raised: "+e);
			return false;
		}
	}
	
	@Transactional
	public boolean updateJobs(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}catch(Exception e){
			System.out.println("Exception raised: "+e);
			return false;
		}
	}
	
	@Transactional
	public boolean deleteJobs(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
			
		}catch(Exception e){
			
			System.out.println("Exception raised: "+e);
			return false;
		}
	}
	
	@Transactional
	public Job getJobDetail(int jobId) {
Session session = sessionFactory.openSession();
		
		Job jobsObj = session.get(Job.class, jobId);
		
		session.close();
		
		return jobsObj;
	}
	
	@Transactional
	public List<Job> getAllJobDetails() {
Session session = sessionFactory.openSession();
		
		List<Job> jobsList= session.createQuery("from JobDetail",Job.class).list();
		
		session.close();
		
		return jobsList;
	}

}
