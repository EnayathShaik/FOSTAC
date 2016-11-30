package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedbackdetail")
public class FeedbackForm {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int feedBackFormId;
	private String feedbackId;
	private String feedbackRating;
	private String userId;
	private String courseId;
	
	/**
	 * @return the feedbackId
	 */
	public String getFeedbackId() {
		return feedbackId;
	}
	/**
	 * @param feedbackId the feedbackId to set
	 */
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	/**
	 * @return the feedbackRating
	 */
	public String getFeedbackRating() {
		return feedbackRating;
	}
	/**
	 * @param feedbackRating the feedbackRating to set
	 */
	public void setFeedbackRating(String feedbackRating) {
		this.feedbackRating = feedbackRating;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
}
