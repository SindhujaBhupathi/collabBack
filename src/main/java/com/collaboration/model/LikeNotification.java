package com.collaboration.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Like_Notifications")
public class LikeNotification {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String blogTitle;
	
	private String username;
	
	private boolean viewedlikes;
	
	@ManyToOne
	private UsersDetails likedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isViewedlikes() {
		return viewedlikes;
	}

	public void setViewedlikes(boolean viewedlikes) {
		this.viewedlikes = viewedlikes;
	}

	public UsersDetails getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(UsersDetails likedBy) {
		this.likedBy = likedBy;
	}

}