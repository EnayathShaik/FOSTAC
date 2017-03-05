package com.ir.form;


public class TrainingCalendarForm {
	
	private int tcid;
	private int courseType;
	private int courseName;
	private int trainingPartner;
	private int trainingCenter;
	private String trainingStartDate;
	private String trainingEndDate;
	private String assessmentDateTime;
	private String assessmentAgencyName;
	private int assessor;
	private String seatCapacity;
	private String type;
	private String userName;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAssessmentDateTime() {
		return assessmentDateTime;
	}
	public void setAssessmentDateTime(String assessmentDateTime) {
		this.assessmentDateTime = assessmentDateTime;
	}

	
	
	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



	
	public int getAssessor() {
		return assessor;
	}
	public void setAssessor(int assessor) {
		this.assessor = assessor;
	}
	public String getAssessmentAgencyName() {
		return assessmentAgencyName;
	}
	public void setAssessmentAgencyName(String assessmentAgencyName) {
		this.assessmentAgencyName = assessmentAgencyName;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	private String trainerName;
	public int getCourseType() {
		return courseType;
	}
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	public int getCourseName() {
		return courseName;
	}
	public void setCourseName(int courseName) {
		this.courseName = courseName;
	}
	public int getTrainingPartner() {
		return trainingPartner;
	}
	public void setTrainingPartner(int trainingPartner) {
		this.trainingPartner = trainingPartner;
	}
	public int getTrainingCenter() {
		return trainingCenter;
	}
	public void setTrainingCenter(int trainingCenter) {
		this.trainingCenter = trainingCenter;
	}

	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainingStartDate() {
		return trainingStartDate;
	}
	public void setTrainingStartDate(String trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}
	public String getTrainingEndDate() {
		return trainingEndDate;
	}
	public void setTrainingEndDate(String trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}
	
	
	
	
	
}
