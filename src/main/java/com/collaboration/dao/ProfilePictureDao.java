package com.collaboration.dao;

import com.collaboration.model.ProfilePicture;

public interface ProfilePictureDao {

	public ProfilePicture getProfilePicture(String username);
	public void saveProfilePicture(ProfilePicture profilePicture);
}
