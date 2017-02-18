package com.ir.model;

public class TrainingPartnerCalendarForm {
	private int tcid;
	private int selCourseType;
	private int selCourseName;
	private String trainingStartDate;
	private String trainingEndDate;
	private String selTrainerNames;
	private String loginId;
	
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
