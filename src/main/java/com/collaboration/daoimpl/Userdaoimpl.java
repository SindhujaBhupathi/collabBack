package com.collaboration.daoimpl;

import java.util.List;
import org.hibernate.*;
import javax.transaction.Transactional;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/*import org.hibernate.Transaction;*/
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.Userdao;
import com.collaboration.model.User;
@Repository("userdao")
public class Userdaoimpl implements Userdao{
Logger Logger=LoggerFactory.getLogger(Userdaoimpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public Userdaoimpl(SessionFactory sessionFactory) {
	
		this.sessionFactory=sessionFactory;
	}
	public boolean saveOrUpdate(User user) {
		Logger.info("save Operation started", user.getUser_id());
		Session session=sessionFactory.openSession();

		Transaction tx=session.beginTransaction();
		user.setEnable(true);
		user.setIsonline(false);
		session.saveOrUpdate(user);
		tx.commit();
		Logger.info("User object has been saved successfually", user.getUser_id());
	
		return true;		
	}
@Transactional
	public User updateUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(user);
		tx.commit();
		
		return user;
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public User getUser(String username) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("username", username));
		User user=(User)c.uniqueResult();
		return user;
	}

	@SuppressWarnings("deprecation")
	public User viewUser(int userid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("userid", userid));
		User user=(User) c.uniqueResult();
		return user;
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Transactional
	public User login(User user) {
		Session session=sessionFactory.openSession();

		Query query=session.createQuery("from UsersDetails where userName=? and password=? and enable=?");
	
		query.setString(0, user.getUserName()); //for assigning the values to parameter username
		query.setString(1, user.getPassword());
		query.setBoolean(2, true);
		User validUsers=(User)query.uniqueResult();
		session.close();
		System.out.println("Dao completed");
		return validUsers;		
	}

	public boolean isUsernameValid(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailValid(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<User> UserList() {
		Criteria c=sessionFactory.openSession().createCriteria(User.class);
		List<User> l = c.list();
		return l;
	}
	
}
