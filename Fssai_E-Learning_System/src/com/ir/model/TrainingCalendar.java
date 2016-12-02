package com.ir.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table(name="trainingCalendar")
public class TrainingCalendar {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int trainingCalendarId;
	
	private int courseType;
	private int courseName;
	private int trainingPartner;
	private int trainingCenter;
	private String trainingDate;
	private String trainingTime;
	private String trainerName;
	private String status;
	private String trainingType;
	private int personalinformationassessorid;
	
	
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
	
	
}
