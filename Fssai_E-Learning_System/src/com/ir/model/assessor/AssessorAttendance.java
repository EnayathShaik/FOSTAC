package com.ir.model.assessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessorAttendance")
public class AssessorAttendance {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int assessorattendanceid;
	private int assessorid;
	private int coursenameid;
	private int trainingcalendarid;
	private String date;
	private String attendance;
	private String filler1;
	/**
	 * @return the assessorattendanceid
	 */
	public int getAssessorattendanceid() {
		return assessorattendanceid;
	}
	/**
	 * @param assessorattendanceid the assessorattendanceid to set
	 */
	public void setAssessorattendanceid(int assessorattendanceid) {
		this.assessorattendanceid = assessorattendanceid;
	}
	/**
	 * @return the assessorid
	 */
	public int getAssessorid() {
		return assessorid;
	}
	/**
	 * @param assessorid the assessorid to set
	 */
	public void setAssessorid(int assessorid) {
		this.assessorid = assessorid;
	}
	/**
	 * @return the coursenameid
	 */
	public int getCoursenameid() {
		return coursenameid;
	}
	/**
	 * @param coursenameid the coursenameid to set
	 */
	public void setCoursenameid(int coursenameid) {
		this.coursenameid = coursenameid;
	}
	/**
	 * @return the trainingcalendarid
	 */
	public int getTrainingcalendarid() {
		return trainingcalendarid;
	}
	/**
	 * @param trainingcalendarid the trainingcalendarid to set
	 */
	public void setTrainingcalendarid(int trainingcalendarid) {
		this.trainingcalendarid = trainingcalendarid;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the attendance
	 */
	public String getAttendance() {
		return attendance;
	}
	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	/**
	 * @return the filler1
	 */
	public String getFiller1() {
		return filler1;
	}
	/**
	 * @param filler1 the filler1 to set
	 */
	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}
	
	
}
