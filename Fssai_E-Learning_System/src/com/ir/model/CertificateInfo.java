package com.ir.model;

public class CertificateInfo {
	private String certificateID;
	private String name;
	private String trainingDate;
	private String trainingAddress;
	private String issueDate;
	private String trainingPartnerName;
	private int courseTypeId;
	private String email;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}
	public void setTrainingPartnerName(String trainingPartnerName) {
		this.trainingPartnerName = trainingPartnerName;
	}
	public String getCertificateID() {
		return certificateID;
	}
	public void setCertificateID(String certificateID) {
		this.certificateID = certificateID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	public String getTrainingAddress() {
		return trainingAddress;
	}
	public void setTrainingAddress(String trainingAddress) {
		this.trainingAddress = trainingAddress;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	
	
}
