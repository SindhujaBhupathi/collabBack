package com.collaboration.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.ProfilePictureDao;
import com.collaboration.model.ProfilePicture;

@Repository
public class ProfilePictureDaoImpl implements ProfilePictureDao{

	@Autowired
	SessionFactory sessionFactory;

	public ProfilePictureDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public ProfilePicture getProfilePicture(String username) {
		Session session = sessionFactory.openSession();
		ProfilePicture profilePicture = (ProfilePicture) session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}

	public void saveProfilePicture(ProfilePicture profilePicture) {
		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.saveOrUpdate(profilePicture);
		 tx.commit();
		 
		 return; 
		}
		
		
	

}