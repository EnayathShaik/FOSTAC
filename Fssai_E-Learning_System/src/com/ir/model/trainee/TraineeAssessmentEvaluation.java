package com.ir.model.trainee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="assessmentevaluationtrainee")
public class TraineeAssessmentEvaluation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int assessmentresultid;
	/**Login id of the trainee */
	private int logindetails;
	/**Course Id for which the assessment has been taken */
	private int courseNameId;
	/**Total number of questions provided for assessment*/
	private int totalQuestions;
	/**Number of correct answers by trainee */
	private int correctAnswers;
	/**Number of incorrect answers by trainee */
	private int incorrectAnswers;
	/**Total score in percentile */
	private double totalScore;
	/**Final result - pass/fail */
	private String result;
	/**
	 * @return the assessmentresultid
	 */
	public int getAssessmentresultid() {
		return assessmentresultid;
	}
	/**
	 * @param assessmentresultid the assessmentresultid to set
	 */
	public void setAssessmentresultid(int assessmentresultid) {
		this.assessmentresultid = assessmentresultid;
	}
	/**
	 * @return the logindetails
	 */
	public int getLogindetails() {
		return logindetails;
	}
	/**
	 * @param logindetails the logindetails to set
	 */
	public void setLogindetails(int logindetails) {
		this.logindetails = logindetails;
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
	 * @return the correctAnswers
	 */
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	/**
	 * @param correctAnswers the correctAnswers to set
	 */
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	/**
	 * @return the incorrectAnswers
	 */
	public int getIncorrectAnswers() {
		return incorrectAnswers;
	}
	/**
	 * @param incorrectAnswers the incorrectAnswers to set
	 */
	public void setIncorrectAnswers(int incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}
	/**
	 * @return the totalScore
	 */
	public double getTotalScore() {
		return totalScore;
	}
	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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
