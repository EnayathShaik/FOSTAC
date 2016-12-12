package com.ir.form;

public class UpdateTrainerAssessmentForm {
	
	/** Types of courses from CourseType master */
	private int courseType;
	/**Name of the course based on the course type */
	private int courseName;
	/** Training center associated for the course */
	private int trainingCenter;
	/** Date of training for the course */
	private String trainingDate;
	/**
	 * @return the courseType
	 */
	public int getCourseType() {
		return courseType;
	}
	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	/**
	 * @return the courseName
	 */
	public int getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(int courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the trainingCenter
	 */
	public int getTrainingCenter() {
		return trainingCenter;
	}
	/**
	 * @param trainingCenter the trainingCenter to set
	 */
	public void setTrainingCenter(int trainingCenter) {
		this.trainingCenter = trainingCenter;
	}
	/**
	 * @return the trainingDate
	 */
	public String getTrainingDate() {
		return trainingDate;
	}
	/**
	 * @param trainingDate the trainingDate to set
	 */
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	
}
