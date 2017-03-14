package com.ir.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class CourseTrainee {
	/**courseName*/
	private String courseName;
	private String courseCode;
	private String courseTypeId;
	private String courseDuration;
	private String courseNameID;
	private String contentLinkInput;
	private String contentNameInput;
	private String assessor;
	private String assessorAgency;
	private String contentType;
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
	 * @return the courseTypeId
	 */
	public String getCourseTypeId() {
		return courseTypeId;
	}
	/**
	 * @param courseTypeId the courseTypeId to set
	 */
	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	/**
	 * @return the courseDuration
	 */
	public String getCourseDuration() {
		return courseDuration;
	}
	/**
	 * @param courseDuration the courseDuration to set
	 */
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	/**
	 * @return the contentLinkInput
	 */
	public String getContentLinkInput() {
		return contentLinkInput;
	}
	/**
	 * @param contentLinkInput the contentLinkInput to set
	 */
	public void setContentLinkInput(String contentLinkInput) {
		this.contentLinkInput = contentLinkInput;
	}
	/**
	 * @return the contentNameInput
	 */
	public String getContentNameInput() {
		return contentNameInput;
	}
	/**
	 * @param contentNameInput the contentNameInput to set
	 */
	public void setContentNameInput(String contentNameInput) {
		this.contentNameInput = contentNameInput;
	}
	public String getAssessor() {
		return assessor;
	}
	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}
	public String getAssessorAgency() {
		return assessorAgency;
	}
	public void setAssessorAgency(String assessorAgency) {
		this.assessorAgency = assessorAgency;
	}
	public String getCourseNameID() {
		return courseNameID;
	}
	public void setCourseNameID(String courseNameID) {
		this.courseNameID = courseNameID;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
	@Override
	public String toString() {
		return "CourseTrainee [courseName=" + courseName + ", courseCode="
				+ courseCode + ", courseTypeId=" + courseTypeId
				+ ", courseDuration=" + courseDuration + ", courseNameID="
				+ courseNameID + ", contentLinkInput=" + contentLinkInput
				+ ", contentNameInput=" + contentNameInput + ", assessor="
				+ assessor + ", assessorAgency=" + assessorAgency
				+ ", contentType=" + contentType + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
	
	
}
