package com.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrepaidToPostpaid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String emailId;
	private String userName;
	private String password;
	private String typeOfSubscriber; 
	private String mobileNum;
	private String prepaidtopostpaid;
	public PrepaidToPostpaid() {}
	public PrepaidToPostpaid(int id, String emailId, String userName, String password, String typeOfSubscriber,
			String mobileNum, String prepaidtopostpaid) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.typeOfSubscriber = typeOfSubscriber;
		this.mobileNum = mobileNum;
		this.prepaidtopostpaid = prepaidtopostpaid;
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
	public String getTypeOfSubscriber() {
		return typeOfSubscriber;
	}
	public void setTypeOfSubscriber(String typeOfSubscriber) {
		this.typeOfSubscriber = typeOfSubscriber;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getPrepaidtopostpaid() {
		return prepaidtopostpaid;
	}
	public void setPrepaidtopostpaid(String prepaidtopostpaid) {
		this.prepaidtopostpaid = prepaidtopostpaid;
	}
}
