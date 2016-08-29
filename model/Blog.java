package com.niit.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Blog {
	@Id
	private String id;
	
	@NotEmpty(message="it should not be empty")
	private String title;
	
	@NotEmpty(message="it should not be empty")
	private String description;
	
	@NotEmpty(message="it should not be empty")
	private String userid;
	
	@NotEmpty(message="it should not be empty")
	private Date creationdate;
	
	@NotEmpty(message="status cannot be empty")
	private char status;
	
	@NotEmpty(message="reason cannot be empty")
	private String reason;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
