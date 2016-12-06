package com.ir.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity @Table(name="postVacancyTrainingCenter")
public class PostVacancyTrainingCenter{
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="postVacancyTrainingCenterId")
	private int id;
	
	@NotNull @OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="courseType")
	private CourseType courseType;
	@NotNull @OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="courseName")
	private CourseName courseName ;
	
	@NotNull @OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="trainingCenter")
	private PersonalInformationTrainingPartner trainingCenter;
	
	@NotNull
	private int requiredExp;
	@NotNull
	private int noOfVacancy;
	@NotNull
	private String trainingDate;
	@NotNull //@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginId")
	private String loginId;
	@Transient
	private int noOfApplications;
	

	public PersonalInformationTrainingPartner getTrainingCenter() {
		return trainingCenter;
	}
	public void setTrainingCenter(PersonalInformationTrainingPartner trainingCenter) {
		this.trainingCenter = trainingCenter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	public CourseName getCourseName() {
		return courseName;
	}
	public void setCourseName(CourseName courseName) {
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
	 * @return the noOfApplications
	 */
	public int getNoOfApplications() {
		return noOfApplications;
	}
	/**
	 * @param noOfApplications the noOfApplications to set
	 */
	public void setNoOfApplications(int noOfApplications) {
		this.noOfApplications = noOfApplications;
	}
	
	

}
