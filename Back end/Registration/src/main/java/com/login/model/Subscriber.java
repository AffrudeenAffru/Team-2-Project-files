package com.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String emailId;
private String userName;
public String getTypeOfSubscriber() {
	return typeOfSubscriber;
}
public void setTypeOfSubscriber(String typeOfSubscriber) {
	this.typeOfSubscriber = typeOfSubscriber;
}
private String password;
private String typeOfSubscriber; 
private String mobileNum;
public Subscriber() {}
public Subscriber(int id, String emailId, String userName, String password,String mobileNum) {
	super();
	this.id = id;
	this.emailId = emailId;
	this.userName = userName;
	this.password = password;
	this.mobileNum= mobileNum;
	
	
}


public String getMobileNum() {
	return mobileNum;
}
public void setMobileNum(String mobileNum) {
	this.mobileNum = mobileNum;
}
public Subscriber(String typeOfSubscriber) {
	super();
	this.typeOfSubscriber = typeOfSubscriber;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
