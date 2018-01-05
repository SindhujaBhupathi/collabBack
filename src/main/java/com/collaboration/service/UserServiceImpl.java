package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.dao.UserDAO;
import com.collaboration.model.User;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserDAO userDAO;
	
	public boolean saveOrUpdate(User users) {

		return userDAO.saveOrUpdate(users);
	}

	public void delete(User user) {
		userDAO.delete(user);
		
	}

	/*public User getUser(String username) {
		return userDAO.getUser(username);
	}*/

	public User viewUser(int userid) {
		
		return userDAO.viewUser(userid);
	}

	public List<User> UserList() {
	
		return userDAO.UserList();
	}

	public User login(User user) {
		
		return userDAO.login(user);
	}

	public boolean isUsernameValid(String username) {
	
		return userDAO.isUsernameValid(username);
	}

	public boolean isEmailValid(String email) {
	
		return userDAO.isEmailValid(email);
	}

	public User updateUser(User users) {

		return userDAO.updateUser(users);
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsername(username);
	}

	
	
	
	
}
