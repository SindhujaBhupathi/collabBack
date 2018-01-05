package com.collaboration.dao;

import com.collaboration.model.BlogPost;
import com.collaboration.model.BlogPostLikes;
import com.collaboration.model.User;

public interface BlogPostLikesDAO {
	BlogPostLikes userLikes(BlogPost blogPost,User User);
    BlogPost updateLikes(BlogPost blogPost, User User);
}
