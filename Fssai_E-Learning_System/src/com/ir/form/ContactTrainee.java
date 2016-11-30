package com.ir.form;

import javax.validation.constraints.NotNull;

public class ContactTrainee {
	
	private  String emailAddress;
	private String messageDetails;
	
	@NotNull
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMessageDetails() {
		return messageDetails;
	}
	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}
	@Override
	public String toString() {
		return "ContactTrainee [emailAddress=" + emailAddress + ", messageDetails=" + messageDetails + "]";
	}
	public ContactTrainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
