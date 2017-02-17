package com.ir.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="adminUserManagement")
public class AdminUserManagement {
	
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int adminUserManagementId;
	
	private String userId;
	private String firstName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String middleName;
	private String lastName;
	private String aadharNumber;
	
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	
	
	public int getAdminUserManagementId() {
		return adminUserManagementId;
	}
	public void setAdminUserManagementId(int adminUserManagementId) {
		this.adminUserManagementId = adminUserManagementId;
	}
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	

}
