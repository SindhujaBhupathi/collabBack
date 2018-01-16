package com.collaboration.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.collaboration.model.BlogComment;
import com.collaboration.model.BlogPost;
import com.collaboration.model.BlogPostLikes;
import com.collaboration.model.Friend;
import com.collaboration.model.Job;
import com.collaboration.model.Notification;
import com.collaboration.model.ProfilePicture;
import com.collaboration.model.UsersDetails;



public class DBConfiguration {

Logger logger =LoggerFactory.getLogger(DBConfiguration.class);
	
	@Bean(name = "dataSource")
		public DataSource getDataSource() {
		logger.info("Data Source Configuration ");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("pro1");
		dataSource.setPassword("pro1");
		logger.info("Data Base Connected ");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		logger.info("========Hibernate Properties=========== ");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql","true");
		logger.info("========Hibernate Properties  has been set=========== ");
		return properties;

	}

	@Autowired
	
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		logger.info("========Hibernate Session Factory=========== ");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(UsersDetails.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClasses(BlogPost.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(BlogPostLikes.class);
		sessionBuilder.addAnnotatedClass(Notification.class);
		sessionBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		
		logger.info("========Hibernate SessionFactory Object created=========== ");
		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
 	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		logger.info("========Hibernate Transaction =========== ");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		logger.info("========Hibernate Transaction object created=========== ");
		return transactionManager;
	}
}
