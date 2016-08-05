package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.dao.UserDAOImpl;

@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/sree");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	System.out.println("one");
    	
    	return dataSource;
    }
    
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	System.out.println("Inside Application Context--Two");
    	properties.put("hibernate.hbm2ddl.auto", "create");
    
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
	
	@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	return sessionBuilder.buildSessionFactory();
    } 
	
	
	// @SuppressWarnings("deprecation")
	   @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(
	    SessionFactory sessionFactory) {
		   HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	    }
	   
	   @Autowired
	    @Bean(name = "userDAO")
	    public UserDAO getUserDao(SessionFactory sessionFactory) {
	    	return new UserDAOImpl(sessionFactory);
	    }
	
}
