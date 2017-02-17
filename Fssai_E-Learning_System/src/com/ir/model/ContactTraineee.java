package com.ir.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

@Entity @Table(name="contactTrainee")
public class ContactTraineee {
	
@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
private int contactTraineeeId;


private String description;

@NotNull @Email
private String emailAddress;
@NotNull
private String messageDetails;

@NotNull
private String userId;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "create_date")
private Date createDate;

@UpdateTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "modify_date")
private Date modifyDate;

public Date getCreateDate() {
	return createDate;
}

public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}

public Date getModifyDate() {
	return modifyDate;
}

public void setModifyDate(Date modifyDate) {
	this.modifyDate = modifyDate;
}

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




public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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
