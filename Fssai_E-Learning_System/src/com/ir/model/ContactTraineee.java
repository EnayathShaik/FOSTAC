package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity @Table(name="contactTrainee")
public class ContactTraineee {
	
@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
private int contactTraineeeId;

@NotNull @Email
private String emailAddress;
@NotNull
private String messageDetails;

@NotNull
private String userId;

public int getContactTraineeeId() {
	return contactTraineeeId;
}
public void setContactTraineeeId(int contactTraineeeId) {
	this.contactTraineeeId = contactTraineeeId;
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
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

@Override
public String toString() {
	return "ContactTraineee [contactTraineeeId=" + contactTraineeeId + ", emailAddress=" + emailAddress
			+ ", messageDetails=" + messageDetails + ", userId=" + userId + "]";
}
public ContactTraineee() {
	super();
	// TODO Auto-generated constructor stub
}
	
}
