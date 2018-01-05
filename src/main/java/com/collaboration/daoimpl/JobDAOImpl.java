package com.collaboration.daoimpl;

import java.util.List;
import org.hibernate.Query;
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
@Transactional
public class JobDAOImpl  implements JobDAO{
	
	
Logger Logger=LoggerFactory.getLogger(JobDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean saveJob(Job job) {
		Session session=sessionFactory.openSession();
		session.save(job);
		session.flush();
		session.close();
		return true;
	}
@Transactional
	public List<Job> getAllJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobs=query.list();
		session.close();
		return jobs;
	}
@Transactional
	public Job getJobById(int id) {
		 Session session=sessionFactory.openSession();
	        Job job=(Job)session.get(Job.class, id);
	        session.close();
	        return job;
	}

}
