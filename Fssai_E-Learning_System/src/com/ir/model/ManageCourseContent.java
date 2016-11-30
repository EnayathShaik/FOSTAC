package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manageCourseContent")
public class ManageCourseContent {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int manageCourseContentId;
	
	private String contentLocationInput;
	private int courseTypeInput;
	private int courseNameInput;
	private String modeOfTrainingInput;
	private String contentTypeInput;
	private String contentNameInput;
	private String contentLinkInput;
	
	
	
	public int getManageCourseContentId() {
		return manageCourseContentId;
	}
	public void setManageCourseContentId(int manageCourseContentId) {
		this.manageCourseContentId = manageCourseContentId;
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
	@Override
	public String toString() {
		return "ManageCourseContent [manageCourseContentId=" + manageCourseContentId + ", contentLocationInput="
				+ contentLocationInput + ", courseTypeInput=" + courseTypeInput + ", courseNameInput=" + courseNameInput
				+ ", modeOfTrainingInput=" + modeOfTrainingInput + ", contentTypeInput=" + contentTypeInput
				+ ", contentNameInput=" + contentNameInput + ", contentLinkInput=" + contentLinkInput + "]";
	}
	public ManageCourseContent() {
		super();
		// TODO Auto-generated constructor stub
	}

}
