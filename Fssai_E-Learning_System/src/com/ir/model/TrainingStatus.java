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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity @Table(name="traningstatus")
public class TrainingStatus {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int trainingstatusId;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String enrolment;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String adminCard;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String training;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String assessment;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String feedback;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String certificate;
	private int profileID;
	private int userID;
	public int getTrainingstatusId() {
		return trainingstatusId;
	}
	public void setTrainingstatusId(int trainingstatusId) {
		this.trainingstatusId = trainingstatusId;
	}
	public String getEnrolment() {
		return enrolment;
	}
	public void setEnrolment(String enrolment) {
		this.enrolment = enrolment;
	}
	public String getAdminCard() {
		return adminCard;
	}
	public void setAdminCard(String adminCard) {
		this.adminCard = adminCard;
	}
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public int getProfileID() {
		return profileID;
	}
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
}
