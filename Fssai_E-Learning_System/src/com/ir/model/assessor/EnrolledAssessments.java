package com.ir.model.assessor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(EnrolledAssessmentId.class)
public class EnrolledAssessments implements Serializable{
	
	
	/** Assessor ID enrolled for the class*/
	@Id
	private int assessmentsenrolledid;
	/** Training calendar ID for which the assessor registered*/
	@Id
	private int trainingcalendarid;
	/** Status of the registration*/
	private String status;
	/**
	 * @return the assessmentsenrolledid
	 */
	public int getAssessmentsenrolledid() {
		return assessmentsenrolledid;
	}
	/**
	 * @param assessmentsenrolledid the assessmentsenrolledid to set
	 */
	public void setAssessmentsenrolledid(int assessmentsenrolledid) {
		this.assessmentsenrolledid = assessmentsenrolledid;
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
	
	
}
