package com.ir.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	private String vacancyType;
	
	private String trainingEndTime;
	
	
	
	public String getVacancyType() {
		return vacancyType;
	}
	public void setVacancyType(String vacancyType) {
		this.vacancyType = vacancyType;
	}

	public String getTrainingEndTime() {
		return trainingEndTime;
	}
	public void setTrainingEndTime(String trainingEndTime) {
		this.trainingEndTime = trainingEndTime;
	}
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
