package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserRole {
	@Id
	
	@NotEmpty(message="id cannot be empty")
	private String id;
	
	@NotEmpty(message="userid cannot be empty")
	private String userid;
	
	@NotEmpty(message="roleid cannot be empty")
	private String roleid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	
}
