package com.collaboration.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.BlogPostLikesDAO;
import com.collaboration.model.BlogPost;
import com.collaboration.model.BlogPostLikes;
import com.collaboration.model.User;
@Repository
@Transactional
public class BlogPostLikesDAOImpl implements  BlogPostLikesDAO{
@Autowired
private SessionFactory sessionFactory;
	public BlogPostLikes userLikes(BlogPost blogPost, User User) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPostLikes where blogPost.id=? and user.username=?");
		query.setInteger(0,blogPost.getId());
		query.setString(1,User.getUserName());
		BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
		return blogPostLikes;
	}

	public BlogPost updateLikes(BlogPost blogPost, User User) {
		// TODO Auto-generated method stub
		return null;
	}

}
