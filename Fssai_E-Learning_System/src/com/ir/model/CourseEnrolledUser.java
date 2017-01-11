package com.ir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="courseEnrolledUser")
public class CourseEnrolledUser {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int courseEnrolledUserId;
	
	@NotNull
	private int trainingCalendarId;
	
	private int loginDetails;

	private int profileId;
	private long rollno; 
	private String paymentstatus;
	private String enrolledby;
	private String userStaus;
	@Column(columnDefinition="varchar(1) default 'N'")
	private String status;
	
	
	
	

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

	public long getRollno() {
		return rollno;
	}

	public void setRollno(long rollno) {
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
	
	
	
	
	
	
}
