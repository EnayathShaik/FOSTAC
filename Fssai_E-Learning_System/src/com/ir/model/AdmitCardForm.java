package com.ir.model;

import java.util.List;

public class AdmitCardForm {
	
	private int admitCardId;
	private int loginId;
	private String loginUserId;
	private String rollNo;
	private String courseName;
	private String name;
	private String category;
	private String gender;
	private String city;
	private String fatherName;
	private List<String> courseContent;
	private int trainingCenterCode;
	private String address;
	private String title;
	/*
	 * new fields added by Jyoti Mekal on  19/02/2017 -- bug fix
	 * */
	private String courseCode;
	private String district;
	private String state;
	private String trainingStartDate;
	private String trainingEndDate;
	private String courseDuration;
	private String trainingCenterName;
	private String mobile;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getTrainingCenterName() {
		return trainingCenterName;
	}
	public void setTrainingCenterName(String trainingCenterName) {
		this.trainingCenterName = trainingCenterName;
	}
	/**
	 * @return the admitCardId
	 */
	public int getAdmitCardId() {
		return admitCardId;
	}
	/**
	 * @param admitCardId the admitCardId to set
	 */
	public void setAdmitCardId(int admitCardId) {
		this.admitCardId = admitCardId;
	}
	/**
	 * @return the loginId
	 */
	public int getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the loginUserId
	 */
	public String getLoginUserId() {
		return loginUserId;
	}
	/**
	 * @param loginUserId the loginUserId to set
	 */
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return the courseContent
	 */
	public List<String> getCourseContent() {
		return courseContent;
	}
	/**
	 * @param courseContent the courseContent to set
	 */
	public void setCourseContent(List<String> courseContent) {
		this.courseContent = courseContent;
	}
	/**
	 * @return the trainingCenterCode
	 */
	public int getTrainingCenterCode() {
		return trainingCenterCode;
	}
	/**
	 * @param trainingCenterCode the trainingCenterCode to set
	 */
	public void setTrainingCenterCode(int trainingCenterCode) {
		this.trainingCenterCode = trainingCenterCode;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "AdmitCardForm [admitCardId=" + admitCardId + ", loginId="
				+ loginId + ", loginUserId=" + loginUserId + ", rollNo="
				+ rollNo + ", courseName=" + courseName + ", name=" + name
				+ ", category=" + category + ", gender=" + gender + ", city="
				+ city + ", fatherName=" + fatherName + ", courseContent="
				+ courseContent + ", trainingCenterCode=" + trainingCenterCode
				+ ", address=" + address + ", title=" + title + ", courseCode="
				+ courseCode + ", district=" + district + ", state=" + state
				+ ", trainingStartDate=" + trainingStartDate
				+ ", trainingEndDate=" + trainingEndDate + ", courseDuration="
				+ courseDuration + ", trainingCenterName=" + trainingCenterName
				+ ", mobile=" + mobile + "]";
	}
	
	
}
