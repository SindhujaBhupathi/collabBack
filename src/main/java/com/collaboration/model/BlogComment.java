package com.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="C_BlogComment")
@Component
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="username")
	private User commentedBy;
	

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="blogpost_id")
	private BlogPost blogPost;
	
	private String commentText;


	private Date commentedOn;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getCommentedBy() {
		return commentedBy;
	}


	public void setCommentedBy(User commentedBy) {
		this.commentedBy = commentedBy;
	}


	public BlogPost getBlogPost() {
		return blogPost;
	}


	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}


	public String getCommentText() {
		return commentText;
	}


	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}


	public Date getCommentedOn() {
		return commentedOn;
	}


	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}

}
