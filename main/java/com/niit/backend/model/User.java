package com.niit.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User {
@Id
private String userId;             //userId

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

private String name;            //Name

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Column(name = "mail_id")
private String mailID;           //MailID

public String getMailID() {
	return mailID;
}

public void setMailID(String mailID) {
	this.mailID = mailID;
}

private String password;        //Password

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

private String address;         //Address 

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

private String country;         //Country

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

private String gender;          //Gender

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

private String mobileno;         //MobileNo

public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}

@Column(name = "admin")
	private boolean isAdmin;      //Admin

public boolean isAdmin() {
	return isAdmin;
}

public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}

}
