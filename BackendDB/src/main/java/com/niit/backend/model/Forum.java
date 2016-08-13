package com.niit.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
	@Table(name="forum")
	@Component
	public class Forum {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		 	@Column(name = "ID")
		private int forumId;
		private String forumTitle;
	 	private String forumContent;
	 	private String userName;
	 	private Date creationDate;

		 	public int getForumId() {
			return forumId;
		}
		public void setForumId(int forumId) {
			this.forumId = forumId;
		}
		public String getForumTitle() {
			return forumTitle;
		}
		public void setForumTitle(String forumTitle) {
			this.forumTitle = forumTitle;
		}
		public String getForumContent() {
			return forumContent;
		}
		public void setForumContent(String forumContent) {
			this.forumContent = forumContent;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
			
		 	
		 	 	
		

}
