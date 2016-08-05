package com.niit.backend.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;

public class UserTest {

	static AnnotationConfigApplicationContext context;
	public UserTest()
	{
		context = new AnnotationConfigApplicationContext ();
		context.scan("com.niit.backend");
		context.refresh();
		
	}
	public static void createUser(User user)
	{
	UserDAO userDAO=(UserDAO) context.getBean("userDAO");
	userDAO.saveOrUpdate(user);
		
	}
	public static void main(String[] args)
	{
	 UserTest t=new UserTest();
	 
	 User user=(User) context.getBean("user");
	 user.setUserId("vijayasree28");
	 user.setName("vijayasree");
	 user.setPassword("1234");
	 user.setAdmin(true);
	 user.setAddress("hyd");
	 user.setMailID("ss@yahoo.com");
	 user.setCountry("India");
	 user.setGender("female");
	 user.setMobileno("8121418561");
	 
	 
	 UserDAO userDAO=(UserDAO) context.getBean("userDAO");
	 userDAO.saveOrUpdate(user);
	 
	 System.out.println("inserted");
	 
	 
	 

	}

}
