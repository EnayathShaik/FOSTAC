package com.ir.model.assessor;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.model.CourseType;

public class MarkAttendanceForm {

	List<IntStringBean> trainingCenters;
	List<CourseType> courseType;

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
	
}
