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


@Entity @Table(name="trainingCalendar")
public class TrainingCalendar {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int trainingCalendarId;
	
	private int courseType;
	private int courseName;
	private int trainingPartner;
	private int trainingCenter;
	private String trainingDate;
	private String assessmentDateTime;
	private String trainingTime;
	private String seatCapacity;
	private String type;
	
	public String getAssessmentDateTime() {
		return assessmentDateTime;
	}
	public void setAssessmentDateTime(String assessmentDateTime) {
		this.assessmentDateTime = assessmentDateTime;
	}

	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAssessmentPartnerName() {
		return assessmentPartnerName;
	}
	public void setAssessmentPartnerName(String assessmentPartnerName) {
		this.assessmentPartnerName = assessmentPartnerName;
	}
	private String trainerName;
	private String status;
	private String trainingType;
	private int personalinformationassessorid;
	private String assessmentDate;
	private String assessmentTime;
	private String assessmentPartnerName;
	private String tcStatus;
	
	public String getTcStatus() {
		return tcStatus;
	}
	public void setTcStatus(String tcStatus) {
		this.tcStatus = tcStatus;
	}
	
	private int assessor;
	
	private int assessorAgency;
	private String batchCode;
	@Column(columnDefinition="int default 0")
	private int seqNo;
	
	
	public int getTrainingCalendarId() {
		return trainingCalendarId;
	}
	public void setTrainingCalendarId(int trainingCalendarId) {
		this.trainingCalendarId = trainingCalendarId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCourseType() {
		return courseType;
	}
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	public int getCourseName() {
		return courseName;
	}
	public void setCourseName(int courseName) {
		this.courseName = courseName;
	}
	public int getTrainingPartner() {
		return trainingPartner;
	}
	public void setTrainingPartner(int trainingPartner) {
		this.trainingPartner = trainingPartner;
	}
	public int getTrainingCenter() {
		return trainingCenter;
	}
	public void setTrainingCenter(int trainingCenter) {
		this.trainingCenter = trainingCenter;
	}
	public String getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	public String getTrainingTime() {
		return trainingTime;
	}
	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	/**
	 * @return the personalinformationassessorid
	 */
	public int getPersonalinformationassessorid() {
		return personalinformationassessorid;
	}
	/**
	 * @param personalinformationassessorid the personalinformationassessorid to set
	 */
	public void setPersonalinformationassessorid(int personalinformationassessorid) {
		this.personalinformationassessorid = personalinformationassessorid;
	}
	public String getAssessmentDate() {
		return assessmentDate;
	}
	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	public String getAssessmentTime() {
		return assessmentTime;
	}
	public void setAssessmentTime(String assessmentTime) {
		this.assessmentTime = assessmentTime;
	}
	public int getAssessor() {
		return assessor;
	}
	public void setAssessor(int assessor) {
		this.assessor = assessor;
	}
	public int getAssessorAgency() {
		return assessorAgency;
	}
	public void setAssessorAgency(int assessorAgency) {
		this.assessorAgency = assessorAgency;
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
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
			
}
