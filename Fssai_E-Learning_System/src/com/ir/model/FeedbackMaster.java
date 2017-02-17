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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="feedBackMaster")
public class FeedbackMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int feedbackTypeID;
	private String courseType;
	private String catogery;
	@NotNull
	private String feedback;
	private String status;
	
	/**
	 * @return the feedbackTypeID
	 */
	public int getFeedbackTypeID() {
		return feedbackTypeID;
	}
	/**
	 * @param feedbackTypeID the feedbackTypeID to set
	 */
	public void setFeedbackTypeID(int feedbackTypeID) {
		this.feedbackTypeID = feedbackTypeID;
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
	 * @return the catogery
	 */
	public String getCatogery() {
		return catogery;
	}
	/**
	 * @param catogery the catogery to set
	 */
	public void setCatogery(String catogery) {
		this.catogery = catogery;
	}
	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
