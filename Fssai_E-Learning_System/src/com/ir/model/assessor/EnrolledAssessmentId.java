package com.ir.model.assessor;

import java.io.Serializable;

public class EnrolledAssessmentId implements Serializable{
	/** Serial version ID */
	private static final long serialVersionUID = 1L;
	/** Assessor ID enrolled for the class*/
	private int assessmentsenrolledid;
	/** Training calendar ID for which the assessor registered*/
	private int trainingcalendarid;
	
	public EnrolledAssessmentId() {}

    public EnrolledAssessmentId(Integer assessmentsenrolledid, Integer trainingcalendarid) {
        this.assessmentsenrolledid = assessmentsenrolledid;
        this.trainingcalendarid = trainingcalendarid;
    }
	
}
