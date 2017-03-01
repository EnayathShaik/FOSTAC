package com.ir.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ManageTrainingPartnerForm {
	
	//@NotNull(message="* error")
	private String userId;
	@NotNull(message="* error")
	private String PAN;
	@NotNull(message="* error")
	private String trainingPartnerName;
	@NotNull(message="* error")
	private String status;
	@NotNull(message="* error")
	private String websiteUrl;
	@NotNull(message="* error")
	private String headOfficeDataAddress1;
	@NotNull(message="* error")
	private String headOfficeDataAddress2;
	@NotNull(message="* error")
	private String pin;
	@NotNull
	private int district;
	@NotNull
	private int state;
	//@NotNull
	private int city;
	@NotEmpty(message="error")
	private String email;
	
	
	private String logindetails;
	private String profileID;
	
	
	public String getLogindetails() {
		return logindetails;
	}
	public void setLogindetails(String logindetails) {
		this.logindetails = logindetails;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}
	public void setTrainingPartnerName(String trainingPartnerName) {
		this.trainingPartnerName = trainingPartnerName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public String getHeadOfficeDataAddress1() {
		return headOfficeDataAddress1;
	}
	public void setHeadOfficeDataAddress1(String headOfficeDataAddress1) {
		this.headOfficeDataAddress1 = headOfficeDataAddress1;
	}
	public String getHeadOfficeDataAddress2() {
		return headOfficeDataAddress2;
	}
	public void setHeadOfficeDataAddress2(String headOfficeDataAddress2) {
		this.headOfficeDataAddress2 = headOfficeDataAddress2;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	
	
	

}
