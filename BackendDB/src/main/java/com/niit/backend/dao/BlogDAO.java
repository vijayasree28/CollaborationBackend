package com.niit.backend.dao;

import com.niit.backend.model.Blog;

public interface BlogDAO {

public Blog get(int blogId);
	
	public Blog getById(int blogId);
	
	public Blog getByName(String username);
	
	public void saveOrUpdate(Blog blog);
	
}
