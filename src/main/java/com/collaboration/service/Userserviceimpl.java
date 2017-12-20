package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.collaboration.dao.Userdao;
import com.collaboration.model.User;

public class Userserviceimpl {
	@Autowired
	private Userdao userdao;
	public boolean saveOrUpdate(User users) {

		return userdao.saveOrUpdate(users);
	}

	public void delete(User user) {
		userdao.delete(user);
		
	}

	public User getUser(String username) {
		return userdao.getUser(username);
	}

	public User viewUser(int userid) {
		
		return userdao.viewUser(userid);
	}

	public List<User> UserList() {
	
		return userdao.UserList();
	}

	public User login(User user) {
		
		return userdao.login(user);
	}

	public boolean isUsernameValid(String username) {
	
		return userdao.isUsernameValid(username);
	}

	public boolean isEmailValid(String email) {
	
		return userdao.isEmailValid(email);
	}

	public User updateUser(User users) {

		return userdao.updateUser(users);
	}
}
