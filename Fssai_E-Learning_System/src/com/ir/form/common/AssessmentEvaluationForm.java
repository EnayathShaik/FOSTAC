package com.ir.form.common;

import java.util.List;

public class AssessmentEvaluationForm {

	/**Course name for which the assessment has been processing */
	public int courseNameId;
	
	/**List of questions id */
	public List<Integer> assessmentQuestionsList;

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
	 * @return the assessmentQuestionsList
	 */
	public List<Integer> getAssessmentQuestionsList() {
		return assessmentQuestionsList;
	}

	/**
	 * @param assessmentQuestionsList the assessmentQuestionsList to set
	 */
	public void setAssessmentQuestionsList(List<Integer> assessmentQuestionsList) {
		this.assessmentQuestionsList = assessmentQuestionsList;
	}
	
}
