package com.ir.model.trainer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessmentevaluationtrainer") 
public class TrainerAssessmentEvaluation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int assessmentresultid;
	/**/
	private int trainerId;
	/**Course Id for which the assessment has been taken */
	private int courseNameId;
	/**Date on which assessment has been done */
	private String assessmentDate;
	/** Training partner id associated */
	private int trainingPartnerId;
	/**Rating provided at TOT Assessment */
	private int rating;
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
	 * @return the trainerId
	 */
	public int getTrainerId() {
		return trainerId;
	}
	/**
	 * @param trainerId the trainerId to set
	 */
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
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
	 * @return the assessmentDate
	 */
	public String getAssessmentDate() {
		return assessmentDate;
	}
	/**
	 * @param assessmentDate the assessmentDate to set
	 */
	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	/**
	 * @return the trainingPartnerId
	 */
	public int getTrainingPartnerId() {
		return trainingPartnerId;
	}
	/**
	 * @param trainingPartnerId the trainingPartnerId to set
	 */
	public void setTrainingPartnerId(int trainingPartnerId) {
		this.trainingPartnerId = trainingPartnerId;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
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
	
}
