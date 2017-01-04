package com.ir.model;

public class TrainingPartnerCalendarForm {
	private int selCourseType;
	private int selCourseName;
	private String seltraineeDate;
	private String seltrainingtime;
	private String selTrainerNames;
	private String loginId;
	
	public String getLoginId() {
		return loginId;
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
	public String getSelTrainerNames() {
		return selTrainerNames;
	}
	public void setSelTrainerNames(String selTrainerNames) {
		this.selTrainerNames = selTrainerNames;
	}
	public String getSeltraineeDate() {
		return seltraineeDate;
	}
	public void setSeltraineeDate(String seltraineeDate) {
		this.seltraineeDate = seltraineeDate;
	}
	public String getSeltrainingtime() {
		return seltrainingtime;
	}
	public void setSeltrainingtime(String seltrainingtime) {
		this.seltrainingtime = seltrainingtime;
	}
	@Override
	public String toString() {
		return "TrainingPartnerCalendarForm [selCourseType=" + selCourseType
				+ ", selCourseName=" + selCourseName + ", seltraineeDate="
				+ seltraineeDate + ", seltrainingtime=" + seltrainingtime
				+ ", selTrainerNames=" + selTrainerNames + "]";
	}
	
	
}
