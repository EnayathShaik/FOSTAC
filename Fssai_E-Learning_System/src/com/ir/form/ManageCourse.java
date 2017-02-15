package com.ir.form;

public class ManageCourse {

	private int courseType;
	private String freePaid;
	private String online;
	private String classroom;
	private String modeOfTraining;
	private String courseCode;
	private int seqNo;
	
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	private String status;
	private String courseName;
	private String duration;
	public int getCourseType() {
		return courseType;
	}
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	public String getFreePaid() {
		return freePaid;
	}
	public void setFreePaid(String freePaid) {
		this.freePaid = freePaid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "ManageCourse [courseType=" + courseType + ", freePaid=" + freePaid + " , status=" + status + ", courseName=" + courseName + ", duration=" + duration + ""
				+ ",online=" + online + ",classroom=" + classroom + "]";
	}
	/**
	 * @return the modeOfTraining
	 */
	public String getModeOfTraining() {
		return modeOfTraining;
	}
	/**
	 * @param modeOfTraining the modeOfTraining to set
	 */
	public void setModeOfTraining(String modeOfTraining) {
		this.modeOfTraining = modeOfTraining;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
}
