package com.collaboration.daoimpl;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.FriendDao;
import com.collaboration.model.Friend;
import com.collaboration.model.UsersDetails;


@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	private SessionFactory sessionFac;

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<UsersDetails> suggestedUserList(String username) {
		Session session=sessionFac 	.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from C_USERS where username in " 
							 					+"(select username from C_USERS where username!=? "
												+"minus "
												+"(select fromId from Friend where toId=?"
												+"union "
												+"select toId from Friend where fromId=? ))");
		sqlQuery.setString(0, username);
		sqlQuery.setString(1, username);
		sqlQuery.setString(2, username);
		sqlQuery.addEntity(UsersDetails.class);
		List<UsersDetails> suggestedUsersList=sqlQuery.list();
		session.close();
		return suggestedUsersList;
	}

	


	@Transactional
	public void addFriendRequest(Friend friend) {
		Session session=sessionFac.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(friend); //insert into friend values(fromId,toId,status)
		tx.commit();
	}

	@Transactional
	public List<Friend> pendingRequests(String username) {
		Session session=sessionFac.openSession();
	Query query=session.createQuery("from Friend where toId=? and status=?");
	query.setString(0, username);
	query.setCharacter(1,'P');
	List<Friend> pendingRequests=query.list();
		return pendingRequests;
	}

	@Transactional
	public void updatePendingRequest(Friend friend) {
	Session session=sessionFac.openSession();
	
	/*Transaction tx=session.beginTransaction();
	session.save(friend); //insert into friend values(fromId,toId,status)
	tx.commit();*/
	Transaction tx=session.beginTransaction();
	if(friend.getStatus()=='A')
		session.update(friend); //update friend set status='A' where id=?
	else
		session.delete(friend);  //delete friend where id=?
	tx.commit();
	session.close();
		
	}

	public List<UsersDetails> listofFriends(String username) {
		Session session=sessionFac.openSession();
	SQLQuery query1=session.createSQLQuery("select * from  C_USERS where username in " + "(select toId from Friend where fromId=? and status='A')");
	SQLQuery query2=session.createSQLQuery("select * from C_USERS where username in (select fromId from Friend where toId=? and status='A') ")	;
	query1.setString(0, username);
	query2.setString(0, username);
	query1.addEntity(UsersDetails.class);
	query2.addEntity(UsersDetails.class);
	List<UsersDetails> list1=query1.list();
	List<UsersDetails> list2=query2.list();
	list1.addAll(list2);
	return list1;
	}

	
	
	
	public List<UsersDetails> listofMutualFriends(String loginId, String suggestedUsername) {
		List<UsersDetails> friendlist1=listofFriends(loginId);
		List<UsersDetails> friendlist2=listofFriends(suggestedUsername);
		List<UsersDetails> mutualFriends=new ArrayList<UsersDetails>();
		for(UsersDetails user1:friendlist1)
		{
			for(UsersDetails user2:friendlist2)
			{
				if(user1.getUsername().equals(user2.getUsername()))
					mutualFriends.add(user1);
			}
		}
		return mutualFriends;
	}

	


	
	

	

}
