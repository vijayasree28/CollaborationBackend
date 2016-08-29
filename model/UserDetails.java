package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class UserDetails {
@Id
	@NotEmpty(message="id cannot be empty")
    private String id;
	
@NotEmpty(message="name should not be empty")
private String name;

@Size(min=6,max=8)
@NotEmpty(message="password cannot be empty")
private String password;

@Transient
@Size(min=6,max=8)
@NotEmpty(message="confirm password cannot be empty")
private String confirmpassword;

@NotEmpty(message="email cannot be empty")
private String email;

@Size(min=10)
@NotEmpty(message="mobile cannot be empty")
private String mobile;

@NotEmpty(message="gender cannot be empty")
private String gender;

@NotEmpty(message="address cannot be empty")
private String address;

@NotEmpty(message="status cannot be empty")
private char status;

@NotEmpty(message="reason cannot be empty")
private String reason;

@Transient
private MultipartFile image;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmpassword() {
	return confirmpassword;
}

public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

public MultipartFile getImage() {
	return image;
}

public void setImage(MultipartFile image) {
	this.image = image;
}



}

