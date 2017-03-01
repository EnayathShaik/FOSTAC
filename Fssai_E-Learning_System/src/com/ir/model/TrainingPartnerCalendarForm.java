package com.ir.model;

public class TrainingPartnerCalendarForm {
	private int tcid;
	private int selCourseType;
	private int selCourseName;
	private String trainingStartDate;
	private String trainingEndDate;
	private String selTrainerNames;
	private String loginId;
	private String assessmentDateTime;
	private String assessmentAgencyName;
	private int assessorName;
	private String seatCapacity;
	private String type;
	private String userName;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}


	public int getAssessorName() {
		return assessorName;
	}
	public void setAssessorName(int assessorName) {
		this.assessorName = assessorName;
	}
	public String getAssessmentAgencyName() {
		return assessmentAgencyName;
	}
	public void setAssessmentAgencyName(String assessmentAgencyName) {
		this.assessmentAgencyName = assessmentAgencyName;
	}
	public String getAssessmentDateTime() {
		return assessmentDateTime;
	}
	public void setAssessmentDateTime(String assessmentDateTime) {
		this.assessmentDateTime = assessmentDateTime;
	}
	public String getLoginId() {
		return loginId;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getSelCourseType() {
		return selCourseType;
	}
	public void setSelCourseType(int selCourseType) {
		this.selCourseType = selCourseType;
	}
	public int getSelCourseName() {
		return selCourseName;
	}
	public void setSelCourseName(int selCourseName) {
		this.selCourseName = selCourseName;
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
	public String getSelTrainerNames() {
		return selTrainerNames;
	}
	public void setSelTrainerNames(String selTrainerNames) {
		this.selTrainerNames = selTrainerNames;
	}

	@Override
	public String toString() {
		return "TrainingPartnerCalendarForm [selCourseType=" + selCourseType
				+ ", selCourseName=" + selCourseName + ", seltraineeDate="
				+ trainingStartDate + ", seltrainingtime=" + trainingEndDate
				+ ", selTrainerNames=" + selTrainerNames + "]";
	}
	
	
}
