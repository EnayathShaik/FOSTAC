package com.ir.model.assessor;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.model.CourseName;
import com.ir.model.CourseType;

public class MarkAttendanceForm {

	int assessorId;
	List<IntStringBean> trainingCenters;
	List<CourseType> courseType;
	List<CourseName> courseName;
	


	/**
	 * @return the trainingCenters
	 */
	public List<IntStringBean> getTrainingCenters() {
		return trainingCenters;
	}

	/**
	 * @param trainingCenters the trainingCenters to set
	 */
	public void setTrainingCenters(List<IntStringBean> trainingCenters) {
		this.trainingCenters = trainingCenters;
	}

	/**
	 * @return the courseType
	 */
	public List<CourseType> getCourseType() {
		return courseType;
	}

	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(List<CourseType> courseType) {
		this.courseType = courseType;
	}

	/**
	 * @return the assessorId
	 */
	public int getAssessorId() {
		return assessorId;
	}

	/**
	 * @param assessorId the assessorId to set
	 */
	public void setAssessorId(int assessorId) {
		this.assessorId = assessorId;
	}
	
	
	/**
	 * @return the courseType
	 */
	public List<CourseName> getCourseName() {
		return courseName;
	}

	/**
	 * @param courseType the courseType to set
	 */
	public void setCoursetName(List<CourseName> courseName) {
		this.courseName = courseName;
	}
	
	
}
