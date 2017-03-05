package com.ir.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ManageCourseContentForm {
	
	private int manageCourseContentId;
	private String contentLocation;
	private int courseType;
	private int courseName;
	private String modeOfTraining;
	private String contentType;
	@NotEmpty(message="* error")
	private String contentName;
	@NotEmpty(message="* error")
	private String contentLink;
	
	private String contentLocationInput;
	private int courseTypeInput;
	private int courseNameInput;
	private String modeOfTrainingInput;
	private String contentTypeInput;
	private String contentNameInput;
	private String contentLinkInput;
	
	
	
	
	
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentLink() {
		return contentLink;
	}
	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}
	public String getContentLocationInput() {
		return contentLocationInput;
	}
	public void setContentLocationInput(String contentLocationInput) {
		this.contentLocationInput = contentLocationInput;
	}
	public int getCourseTypeInput() {
		return courseTypeInput;
	}
	public void setCourseTypeInput(int courseTypeInput) {
		this.courseTypeInput = courseTypeInput;
	}
	public int getCourseNameInput() {
		return courseNameInput;
	}
	public void setCourseNameInput(int courseNameInput) {
		this.courseNameInput = courseNameInput;
	}
	public String getModeOfTrainingInput() {
		return modeOfTrainingInput;
	}
	public void setModeOfTrainingInput(String modeOfTrainingInput) {
		this.modeOfTrainingInput = modeOfTrainingInput;
	}
	public String getContentTypeInput() {
		return contentTypeInput;
	}
	public void setContentTypeInput(String contentTypeInput) {
		this.contentTypeInput = contentTypeInput;
	}
	public String getContentNameInput() {
		return contentNameInput;
	}
	public void setContentNameInput(String contentNameInput) {
		this.contentNameInput = contentNameInput;
	}
	public String getContentLinkInput() {
		return contentLinkInput;
	}
	public void setContentLinkInput(String contentLinkInput) {
		this.contentLinkInput = contentLinkInput;
	}
	public int getManageCourseContentId() {
		return manageCourseContentId;
	}
	public void setManageCourseContentId(int manageCourseContentId) {
		this.manageCourseContentId = manageCourseContentId;
	}
	public String getContentLocation() {
		return contentLocation;
	}
	public void setContentLocation(String contentLocation) {
		this.contentLocation = contentLocation;
	}
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
	public String getModeOfTraining() {
		return modeOfTraining;
	}
	public void setModeOfTraining(String modeOfTraining) {
		this.modeOfTraining = modeOfTraining;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	@Override
	public String toString() {
		return "ManageCourseContentForm [manageCourseContentId=" + manageCourseContentId + ", contentLocation="
				+ contentLocation + ", courseType=" + courseType + ", courseName=" + courseName + ", modeOfTraining="
				+ modeOfTraining + ", contentType=" + contentType + ", contentLocationInput=" + contentLocationInput
				+ ", courseTypeInput=" + courseTypeInput + ", courseNameInput=" + courseNameInput
				+ ", modeOfTrainingInput=" + modeOfTrainingInput + ", contentTypeInput=" + contentTypeInput
				+ ", contentNameInput=" + contentNameInput + ", contentLinkInput=" + contentLinkInput + "]";
	}
	public ManageCourseContentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
