package com.ir.model;

import java.util.List;

/** 
 * Bean for processing data for Online assessment of trainee
 * @author user
 *
 */
public class TraineeAssessment {
	
	/** Name of the course for which assessment is submitting **/
	private String courseName;
	private int courseNameId;
	private List<AssessmentQuestion> listAssessmentQuestion; 
	private int totalQuestions;
	private String loginId;
	private String trainingCalendar;
	
	/**
	 * @return the listAssessmentQuestion
	 */
	public List<AssessmentQuestion> getListAssessmentQuestion() {
		return listAssessmentQuestion;
	}

	/**
	 * @param listAssessmentQuestion the listAssessmentQuestion to set
	 */
	public void setListAssessmentQuestion(List<AssessmentQuestion> listAssessmentQuestion) {
		this.listAssessmentQuestion = listAssessmentQuestion;
	}

	/**
	 * @return the totalQuestions
	 */
	public int getTotalQuestions() {
		return totalQuestions;
	}

	/**
	 * @param totalQuestions the totalQuestions to set
	 */
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the trainingCalendar
	 */
	public String getTrainingCalendar() {
		return trainingCalendar;
	}

	/**
	 * @param trainingCalendar the trainingCalendar to set
	 */
	public void setTrainingCalendar(String trainingCalendar) {
		this.trainingCalendar = trainingCalendar;
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

}
