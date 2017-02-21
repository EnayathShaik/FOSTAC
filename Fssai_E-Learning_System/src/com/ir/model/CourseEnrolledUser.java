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

@Entity 
@Table(name="courseEnrolledUser")
public class CourseEnrolledUser {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int courseEnrolledUserId;
	
	@NotNull
	private int trainingCalendarId;
	
	private int loginDetails;

	private int profileId;
	private String rollno; 
	private String paymentstatus;
	private String enrolledby;
	private String userStaus;
	private String userStausAssessor;
	private String result;
	private String assessorComment;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String status;
	private String certificateID; 
	@Column(columnDefinition="int default 0")
	private int rollSeqNo; 
	@Column(columnDefinition="int default 0")
	private int certificateSeqNo; 
	private String issueDate;
	
	
	

	public String getUserStaus() {
		return userStaus;
	}

	public void setUserStaus(String userStaus) {
		this.userStaus = userStaus;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getEnrolledby() {
		return enrolledby;
	}

	public void setEnrolledby(String enrolledby) {
		this.enrolledby = enrolledby;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}


	public int getCourseEnrolledUserId() {
		return courseEnrolledUserId;
	}

	public void setCourseEnrolledUserId(int courseEnrolledUserId) {
		this.courseEnrolledUserId = courseEnrolledUserId;
	}

	public int getTrainingCalendarId() {
		return trainingCalendarId;
	}

	public void setTrainingCalendarId(int trainingCalendarId) {
		this.trainingCalendarId = trainingCalendarId;
	}

	public int getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(int loginDetails) {
		this.loginDetails = loginDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserStausAssessor() {
		return userStausAssessor;
	}

	public void setUserStausAssessor(String userStausAssessor) {
		this.userStausAssessor = userStausAssessor;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAssessorComment() {
		return assessorComment;
	}

	public void setAssessorComment(String assessorComment) {
		this.assessorComment = assessorComment;
	}

	public String getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(String certificateID) {
		this.certificateID = certificateID;
	}

	public int getRollSeqNo() {
		return rollSeqNo;
	}

	public void setRollSeqNo(int rollSeqNo) {
		this.rollSeqNo = rollSeqNo;
	}

	public int getCertificateSeqNo() {
		return certificateSeqNo;
	}

	public void setCertificateSeqNo(int certificateSeqNo) {
		this.certificateSeqNo = certificateSeqNo;
	}
	
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

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	
}
