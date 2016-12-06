package com.ir.model.assessmentagency;

import java.util.List;

import com.ir.model.CourseType;

public class AssessmentAgencyForm {
	
	private int manageassessmentagencyid;
	private List<String> agencyName;
	private List<String> assessor;
	private List<CourseType> courseTypes;
	/**
	 * @return the manageassessmentagencyid
	 */
	public int getManageassessmentagencyid() {
		return manageassessmentagencyid;
	}
	/**
	 * @param manageassessmentagencyid the manageassessmentagencyid to set
	 */
	public void setManageassessmentagencyid(int manageassessmentagencyid) {
		this.manageassessmentagencyid = manageassessmentagencyid;
	}
	/**
	 * @return the agencyName
	 */
	public List<String> getAgencyName() {
		return agencyName;
	}
	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(List<String> agencyName) {
		this.agencyName = agencyName;
	}
	/**
	 * @return the assessor
	 */
	public List<String> getAssessor() {
		return assessor;
	}
	/**
	 * @param assessor the assessor to set
	 */
	public void setAssessor(List<String> assessor) {
		this.assessor = assessor;
	}
	/**
	 * @return the courseTypes
	 */
	public List<CourseType> getCourseTypes() {
		return courseTypes;
	}
	/**
	 * @param courseTypes the courseTypes to set
	 */
	public void setCourseTypes(List<CourseType> courseTypes) {
		this.courseTypes = courseTypes;
	}
	
}
