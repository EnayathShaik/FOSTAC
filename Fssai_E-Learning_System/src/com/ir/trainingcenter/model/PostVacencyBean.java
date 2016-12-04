package com.ir.trainingcenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedBackMaster")
public class PostVacencyBean {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int postVacencyId;
	private int courseTypeId;
	private String courseType;
	private int courseNameId;
	private String courseName;
	private String trainingDate;
	private int requiredExp;
	private int noOfVacency;
	/**
	 * @return the postVacencyId
	 */
	public int getPostVacencyId() {
		return postVacencyId;
	}
	/**
	 * @param postVacencyId the postVacencyId to set
	 */
	public void setPostVacencyId(int postVacencyId) {
		this.postVacencyId = postVacencyId;
	}
	/**
	 * @return the courseTypeId
	 */
	public int getCourseTypeId() {
		return courseTypeId;
	}
	/**
	 * @param courseTypeId the courseTypeId to set
	 */
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	/**
	 * @return the courseType
	 */
	public String getCourseType() {
		return courseType;
	}
	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	/**
	 * @return the courseNameId
	 */
	public int getCourseNameId() {
		return courseNameId;
	}
	/**
	 * @param courseNameId the courseNameId to set
	 */
	public void setCourseNameId(int courseNameId) {
		this.courseNameId = courseNameId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the trainingDate
	 */
	public String getTrainingDate() {
		return trainingDate;
	}
	/**
	 * @param trainingDate the trainingDate to set
	 */
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	/**
	 * @return the requiredExp
	 */
	public int getRequiredExp() {
		return requiredExp;
	}
	/**
	 * @param requiredExp the requiredExp to set
	 */
	public void setRequiredExp(int requiredExp) {
		this.requiredExp = requiredExp;
	}
	/**
	 * @return the noOfVacency
	 */
	public int getNoOfVacency() {
		return noOfVacency;
	}
	/**
	 * @param noOfVacency the noOfVacency to set
	 */
	public void setNoOfVacency(int noOfVacency) {
		this.noOfVacency = noOfVacency;
	}
}
