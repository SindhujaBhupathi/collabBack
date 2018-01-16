package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Notification;


public interface NotificationDao {

	
	public List<Notification>getNotification(String username,int viewed);
    public Notification updateNotification(int notificationId);
}
