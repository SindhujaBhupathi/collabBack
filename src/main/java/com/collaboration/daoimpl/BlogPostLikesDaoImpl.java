package com.collaboration.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.BlogPostLikesDao;
import com.collaboration.model.BlogPost;
import com.collaboration.model.BlogPostLikes;

import com.collaboration.model.UsersDetails;

@Repository
public class BlogPostLikesDaoImpl implements BlogPostLikesDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	     @Transactional
		public BlogPostLikes userLikes(BlogPost blogPost, UsersDetails user) {
			Session session=sessionFactory.openSession();
			
			Query query=session.createQuery("from BlogPostLikes where blogPost.id=? and user.username=? ");
			System.out.println("BlogPost id  " + blogPost.getId());
			System.out.println("Username " + user.getUsername());
			query.setInteger(0, blogPost.getId());
			query.setString(1, user.getUsername());
			//blogPostlikes = null [glyphicon in black color] / 1 [glyphicon in blue color] object
			BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
			System.out.println(blogPostLikes);
			session.close();
			return blogPostLikes;
			
		}
	
	   // @Transactional
		public BlogPost updateLikes(BlogPost blogPost, UsersDetails user) {
			Session session=sessionFactory.openSession();
		    Transaction tx = null;
		    tx = session.beginTransaction();
			BlogPostLikes blogPostLikes=userLikes(blogPost,user);
			
			if(blogPostLikes==null){ //insert into blogpostlikes, increment blogpost.likes
				BlogPostLikes insertLikes=new BlogPostLikes();
	            insertLikes.setBlogPost(blogPost);//FK blogpost_id
				insertLikes.setUser(user);//FK user_username
				session.save(insertLikes); //insert into blogpostlikes
				blogPost.setLikes(blogPost.getLikes() + 1); //increment the number of likes
				session.update(blogPost);//update blogpost set likes=.. where id=?
			}
			else{//unlike
				session.delete(blogPostLikes); //delete from blogpostlikes
				blogPost.setLikes(blogPost.getLikes()-1); //decrement the number of likes
				session.merge(blogPost); //update blogpost set likes ...
			}
			tx.commit();
			session.close();
			return blogPost;
		}

	
		
}