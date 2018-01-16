package com.collaboration.dao;
import com.collaboration.model.BlogPost;
import com.collaboration.model.BlogPostLikes;
import com.collaboration.model.UsersDetails;

public interface BlogPostLikesDao{

	//select * from blogpostlikes where blogpost_id=? and user_username=?
		//if user already liked the post, 1 object
		//if user has not yet liked the post, null object
	BlogPostLikes userLikes(BlogPost blogPost,UsersDetails user);

	//increment / decrement the number of likes
	//insert into blogpostlikes / delete from blogpostlikes 
	BlogPost updateLikes(BlogPost blogPost, UsersDetails user);
}
