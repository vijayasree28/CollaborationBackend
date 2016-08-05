package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.User;

public interface UserDAO {

	public List<User> list();

	public User get(String userId);

	public void saveOrUpdate(User user);
	
    public void delete(String userId);
	
	public boolean isValidUser(String userId, String name, boolean isAdmin);
 
}
