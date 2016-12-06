package com.ir.model.assessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessmentResult")
public class AssessmentResult {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int assessmentresultid;
	private int assessorid;
	private int participantid;
	private int trainingcalendarid;
	private String updateddate;
	private String result;
	private String comments;
	private String filler1;
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
	 * @return the assessorid
	 */
	public int getAssessorid() {
		return assessorid;
	}
	/**
	 * @param assessorid the assessorid to set
	 */
	public void setAssessorid(int assessorid) {
		this.assessorid = assessorid;
	}
	/**
	 * @return the participantid
	 */
	public int getParticipantid() {
		return participantid;
	}
	/**
	 * @param participantid the participantid to set
	 */
	public void setParticipantid(int participantid) {
		this.participantid = participantid;
	}
	/**
	 * @return the trainingcalendarid
	 */
	public int getTrainingcalendarid() {
		return trainingcalendarid;
	}
	/**
	 * @param trainingcalendarid the trainingcalendarid to set
	 */
	public void setTrainingcalendarid(int trainingcalendarid) {
		this.trainingcalendarid = trainingcalendarid;
	}
	
	/**
	 * @return the updateddate
	 */
	public String getUpdateddate() {
		return updateddate;
	}
	/**
	 * @param updateddate the updateddate to set
	 */
	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the filler1
	 */
	public String getFiller1() {
		return filler1;
	}
	/**
	 * @param filler1 the filler1 to set
	 */
	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}
	
}
