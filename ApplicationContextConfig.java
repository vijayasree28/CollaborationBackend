package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.dao.BlogDAO;
import com.niit.backend.dao.BlogDAOImpl;
import com.niit.backend.dao.ForumDAO;
import com.niit.backend.dao.ForumDAOImpl;
import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.dao.UserDetailsDAOImpl;
import com.niit.backend.model.Blog;
import com.niit.backend.model.Forum;
import com.niit.backend.model.UserDetails;



@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name="dataSource")
	public DataSource getOracleDataSource() {
		
    	//BasicDataSource dataSource = new BasicDataSource();
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    	dataSource.setUsername("COLLABORATION"); //COLLABORATION
    	dataSource.setPassword("SREE28"); 
    	
    	System.out.println("IN oracledb method one");
    	
    	Properties connectionPoperties = new Properties();
    	connectionPoperties.setProperty("hibernate.hbm2ddl.auto", "update");
    	connectionPoperties.setProperty("hibernate.show_sql", "true");
    	connectionPoperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	
    	System.out.println("IN oracledb method two");
    	
    	return dataSource;
    }
    
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	
    	//properties.put("hibernate.hbm2ddl.auto", "update");
    
    	properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	
    	System.out.println("Inside Application Context");
    	
    	return properties;
    }
	
	

	
	@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	
    	sessionBuilder.addAnnotatedClass(UserDetails.class);
    	sessionBuilder.addAnnotatedClass(Blog.class);
    	sessionBuilder.addAnnotatedClass(Forum.class);
    	
    	System.out.println("in SF method ");
    	
    	return sessionBuilder.buildSessionFactory();
    } 
	
	
	
	   @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(
	    SessionFactory sessionFactory) {
		   HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	    }
	   
	   @Autowired
	    @Bean(name = "userDetailsDAO")
	    public UserDetailsDAO getUserDetailsDAO(SessionFactory sessionFactory) {
	    	System.out.println("in userDetailsDAO");
		   return new UserDetailsDAOImpl(sessionFactory);
	   }
	   
	   @Autowired
	    @Bean(name = "blogDAO")
	    public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
			System.out.println("in blog DAO");
	    	return new BlogDAOImpl(sessionFactory);
	    }
	   
	   @Autowired
	    @Bean(name = "forumDAO")
	    public ForumDAO getForumDAO(SessionFactory sessionFactory) {
			System.out.println("in forum DAO");
	    	return new ForumDAOImpl(sessionFactory);
	    }
	
}
