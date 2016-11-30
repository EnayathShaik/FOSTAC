package com.ir.form;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="assessmentanswers")
public class AssessmentAnswerCriteria {
	
	private int courseNameId;
	private int questionId;
	private int questionNumber;
	private int selectedAnswer;
	private int loginId;
	
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
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the questionNumber
	 */
	public int getQuestionNumber() {
		return questionNumber;
	}
	/**
	 * @param questionNumber the questionNumber to set
	 */
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	/**
	 * @return the selectedAnswer
	 */
	public int getSelectedAnswer() {
		return selectedAnswer;
	}
	/**
	 * @param selectedAnswer the selectedAnswer to set
	 */
	public void setSelectedAnswer(int selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	/**
	 * @return the loginId
	 */
	public int getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	
}
