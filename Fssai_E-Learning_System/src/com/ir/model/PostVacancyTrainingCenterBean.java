package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="trainingcentervacancyenrolled")
public class PostVacancyTrainingCenterBean {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int vacancyEnrolledId;
	private int courseType;
	private int courseName ;
	private int requiredExp;
	private int noOfVacancy;
	private String trainingDate;
	private String loginId;
	private int trainingCenter;
	private String status;
	@Transient
	private PersonalInformationTrainingPartner personalInformationTrainingPartner;
	@Transient
	private String coursetypeName;
	@Transient
	private String strCourseName;
	public int getTrainingCenter() {
		return trainingCenter;
	}
	public void setTrainingCenter(int trainingCenter) {
		this.trainingCenter = trainingCenter;
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
	public int getRequiredExp() {
		return requiredExp;
	}
	public void setRequiredExp(int requiredExp) {
		this.requiredExp = requiredExp;
	}
	public int getNoOfVacancy() {
		return noOfVacancy;
	}
	public void setNoOfVacancy(int noOfVacancy) {
		this.noOfVacancy = noOfVacancy;
	}
	public String getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	/**
	 * @return the vacancyEnrolledId
	 */
	public int getVacancyEnrolledId() {
		return vacancyEnrolledId;
	}
	/**
	 * @param vacancyEnrolledId the vacancyEnrolledId to set
	 */
	public void setVacancyEnrolledId(int vacancyEnrolledId) {
		this.vacancyEnrolledId = vacancyEnrolledId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the personalInformationTrainingPartner
	 */
	public PersonalInformationTrainingPartner getPersonalInformationTrainingPartner() {
		return personalInformationTrainingPartner;
	}
	/**
	 * @param personalInformationTrainingPartner the personalInformationTrainingPartner to set
	 */
	public void setPersonalInformationTrainingPartner(PersonalInformationTrainingPartner personalInformationTrainingPartner) {
		this.personalInformationTrainingPartner = personalInformationTrainingPartner;
	}
	/**
	 * @return the coursetypeName
	 */
	public String getCoursetypeName() {
		return coursetypeName;
	}
	/**
	 * @param coursetypeName the coursetypeName to set
	 */
	public void setCoursetypeName(String coursetypeName) {
		this.coursetypeName = coursetypeName;
	}
	/**
	 * @return the strCourseName
	 */
	public String getStrCourseName() {
		return strCourseName;
	}
	/**
	 * @param strCourseName the strCourseName to set
	 */
	public void setStrCourseName(String strCourseName) {
		this.strCourseName = strCourseName;
	}

}
