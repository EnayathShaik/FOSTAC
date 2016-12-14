package com.ir.model;

public class TrainingPartnerCalendarForm {
	private int selCourseType;
	private int selCourseName;
	private String trainingdate;
	private String trainingTime;
	private String selTrainerNames;
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
	public String getTrainingdate() {
		return trainingdate;
	}
	public void setTrainingdate(String trainingdate) {
		this.trainingdate = trainingdate;
	}
	public String getTrainingTime() {
		return trainingTime;
	}
	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
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
				+ ", selCourseName=" + selCourseName + ", trainingdate="
				+ trainingdate + ", trainingTime=" + trainingTime
				+ ", selTrainerNames=" + selTrainerNames + "]";
	}
	
	
	
}
