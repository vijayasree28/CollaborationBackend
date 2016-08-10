package com.niit.backend.dao;



import com.niit.backend.model.User;

public interface UserDAO {

	

	public User get(int userId);
	
	public User getById(int userId);
	
	public User getByName(String userName);
	
	public void saveOrUpdate(User user);
	
    	
}
