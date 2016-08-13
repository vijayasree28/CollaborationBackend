package com.niit.backend.dao;

import com.niit.backend.model.Forum;

public interface ForumDAO {
	
	
	public void saveOrUpdate();
	 	public Forum get(int forumId);
	 	public Forum getByName(String userName);
	 	public Forum getById(int forumId);

}
