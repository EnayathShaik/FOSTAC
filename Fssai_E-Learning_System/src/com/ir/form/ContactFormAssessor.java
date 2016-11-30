package com.ir.form;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class ContactFormAssessor {

	@Id @GeneratedValue
	private int contactAssessorId;

	@NotNull @Email
	private String emailAddress;
	@NotNull
	private String messageDetails;

	@NotNull
	private int userId;

	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ContactTraineee [contactAssessorId=" + contactAssessorId + ", emailAddress=" + emailAddress
				+ ", messageDetails=" + messageDetails + ", userId=" + userId + "]";
	}
	public int getContactAssessorId() {
		return contactAssessorId;
	}
	public void setContactAssessorId(int contactAssessorId) {
		this.contactAssessorId = contactAssessorId;
	}
	public ContactFormAssessor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
