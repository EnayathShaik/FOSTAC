package com.ir.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class RegistrationFormAssessor {
	
	//@NotNull
	private String UserId;
	@NotNull
	private int Title;
	@NotNull
	@Size(min=12, max=12 , message="* error")
	private String AadharNumber;
	@NotNull
	@Size(min=1, max=20 , message="* error")
	private String FirstName;
	//@NotNull
	//@Size(min=1, max=20 , message="* error")
	private String MiddleName;
	@NotNull
	@Size(min=1, max=20 , message="* error")
	private String LastName;
	@NotNull
	@Size(min=1, max=20 , message="* error")
	private String DOB;
	@NotNull
	@Size(min=1, max=20 , message="* error")
	private String gender;
	@NotNull(message="please select agency name")
	private int AssessmentAgencyName;
	
	
	@NotNull
	@Size(min=1, max=100 , message="* error")
	private String AssessorPermanentLine1;
	@NotNull
	@Size(min=1, max=100 , message="* error")
	private String AssessorPermanentLine2;
	@NotNull
	private int AssessorrPermanentState;
	@NotNull
	private int AssessorPermanentDistrict;
	@NotNull
	private int AssessorPermanentCity;
	@NotNull
	@Size(min=1, max=20 , message="* error")
	private String AssessorPermanentPincode;
	@NotNull @Email(message="& error")
	private String AssessorPermanentEmail;
	@NotNull
	@Size(min=10, max=10 , message="* error")
	private String AssessorPermanentMobile;
	@NotNull
	@Size(min=1, max=100 , message="* error")
	private String AssessorCorrespondenceLine1;
	@NotNull
	@Size(min=1, max=100 , message="* error")
	private String AssessorCorrespondenceLine2;
	@NotNull
	private int AssessorCorrespondenceState;
	@NotNull
	private int AssessorCorrespondenceDistrict;
	@NotNull
	private int AssessorCorrespondenceCity;
	@NotNull
	@Size(min=6, max=6 , message="* error")
	private String AssessorCorrespondencePincode;

	@NotNull 
	private int ReleventExpOfAuditInYear;
	@NotNull(message="* error")
	private String ReleventExpOfAuditInMonth;
	@NotNull
	private String HowManyAssessmentConductInAMonth;
	
	///@NotNull
	private String BasicCourse;
	//@NotNull
	private String AdvanceCourse;
	//@NotNull
	private String SpecialCourse;
	
	private String BasicCourse1;
	private String AdvanceCourse1;
	private String SpecialCourse1;
	
	
	private List<String> basicCourses;
	private List<String> advanceCourses;
	private List<String> specialCourses;
	
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public int getTitle() {
		return Title;
	}
	public void setTitle(int title) {
		Title = title;
	}
	public String getAadharNumber() {
		return AadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAssessmentAgencyName() {
		return AssessmentAgencyName;
	}
	public void setAssessmentAgencyName(int assessmentAgencyName) {
		AssessmentAgencyName = assessmentAgencyName;
	}
	public String getAssessorPermanentLine1() {
		return AssessorPermanentLine1;
	}
	public void setAssessorPermanentLine1(String assessorPermanentLine1) {
		AssessorPermanentLine1 = assessorPermanentLine1;
	}
	public String getAssessorPermanentLine2() {
		return AssessorPermanentLine2;
	}
	public void setAssessorPermanentLine2(String assessorPermanentLine2) {
		AssessorPermanentLine2 = assessorPermanentLine2;
	}
	public int getAssessorrPermanentState() {
		return AssessorrPermanentState;
	}
	public void setAssessorrPermanentState(int assessorrPermanentState) {
		AssessorrPermanentState = assessorrPermanentState;
	}
	public int getAssessorPermanentDistrict() {
		return AssessorPermanentDistrict;
	}
	public void setAssessorPermanentDistrict(int assessorPermanentDistrict) {
		AssessorPermanentDistrict = assessorPermanentDistrict;
	}
	public int getAssessorPermanentCity() {
		return AssessorPermanentCity;
	}
	public void setAssessorPermanentCity(int assessorPermanentCity) {
		AssessorPermanentCity = assessorPermanentCity;
	}
	public String getAssessorPermanentPincode() {
		return AssessorPermanentPincode;
	}
	public void setAssessorPermanentPincode(String assessorPermanentPincode) {
		AssessorPermanentPincode = assessorPermanentPincode;
	}
	public String getAssessorPermanentEmail() {
		return AssessorPermanentEmail;
	}
	public void setAssessorPermanentEmail(String assessorPermanentEmail) {
		AssessorPermanentEmail = assessorPermanentEmail;
	}
	public String getAssessorPermanentMobile() {
		return AssessorPermanentMobile;
	}
	public void setAssessorPermanentMobile(String assessorPermanentMobile) {
		AssessorPermanentMobile = assessorPermanentMobile;
	}
	public String getAssessorCorrespondenceLine1() {
		return AssessorCorrespondenceLine1;
	}
	public void setAssessorCorrespondenceLine1(String assessorCorrespondenceLine1) {
		AssessorCorrespondenceLine1 = assessorCorrespondenceLine1;
	}
	public String getAssessorCorrespondenceLine2() {
		return AssessorCorrespondenceLine2;
	}
	public void setAssessorCorrespondenceLine2(String assessorCorrespondenceLine2) {
		AssessorCorrespondenceLine2 = assessorCorrespondenceLine2;
	}
	public int getAssessorCorrespondenceState() {
		return AssessorCorrespondenceState;
	}
	public void setAssessorCorrespondenceState(int assessorCorrespondenceState) {
		AssessorCorrespondenceState = assessorCorrespondenceState;
	}
	public int getAssessorCorrespondenceDistrict() {
		return AssessorCorrespondenceDistrict;
	}
	public void setAssessorCorrespondenceDistrict(int assessorCorrespondenceDistrict) {
		AssessorCorrespondenceDistrict = assessorCorrespondenceDistrict;
	}
	public int getAssessorCorrespondenceCity() {
		return AssessorCorrespondenceCity;
	}
	public void setAssessorCorrespondenceCity(int assessorCorrespondenceCity) {
		AssessorCorrespondenceCity = assessorCorrespondenceCity;
	}
	public String getAssessorCorrespondencePincode() {
		return AssessorCorrespondencePincode;
	}
	public void setAssessorCorrespondencePincode(String assessorCorrespondencePincode) {
		AssessorCorrespondencePincode = assessorCorrespondencePincode;
	}
	public int getReleventExpOfAuditInYear() {
		return ReleventExpOfAuditInYear;
	}
	public void setReleventExpOfAuditInYear(int releventExpOfAuditInYear) {
		ReleventExpOfAuditInYear = releventExpOfAuditInYear;
	}
	public String getReleventExpOfAuditInMonth() {
		return ReleventExpOfAuditInMonth;
	}
	public void setReleventExpOfAuditInMonth(String releventExpOfAuditInMonth) {
		ReleventExpOfAuditInMonth = releventExpOfAuditInMonth;
	}
	public String getHowManyAssessmentConductInAMonth() {
		return HowManyAssessmentConductInAMonth;
	}
	public void setHowManyAssessmentConductInAMonth(String howManyAssessmentConductInAMonth) {
		HowManyAssessmentConductInAMonth = howManyAssessmentConductInAMonth;
	}
	public String getBasicCourse() {
		return BasicCourse;
	}
	public void setBasicCourse(String basicCourse) {
		BasicCourse = basicCourse;
	}
	public String getAdvanceCourse() {
		return AdvanceCourse;
	}
	public void setAdvanceCourse(String advanceCourse) {
		AdvanceCourse = advanceCourse;
	}
	public String getSpecialCourse() {
		return SpecialCourse;
	}
	public void setSpecialCourse(String specialCourse) {
		SpecialCourse = specialCourse;
	}
	/**
	 * @return the basicCourses
	 */
	public List<String> getBasicCourses() {
		return basicCourses;
	}
	/**
	 * @param basicCourses the basicCourses to set
	 */
	public void setBasicCourses(List<String> basicCourses) {
		this.basicCourses = basicCourses;
	}
	/**
	 * @return the advanceCourses
	 */
	public List<String> getAdvanceCourses() {
		return advanceCourses;
	}
	/**
	 * @param advanceCourses the advanceCourses to set
	 */
	public void setAdvanceCourses(List<String> advanceCourses) {
		this.advanceCourses = advanceCourses;
	}
	/**
	 * @return the specialCourses
	 */
	public List<String> getSpecialCourses() {
		return specialCourses;
	}
	/**
	 * @param specialCourses the specialCourses to set
	 */
	public void setSpecialCourses(List<String> specialCourses) {
		this.specialCourses = specialCourses;
	}
	/**
	 * @return the basicCourse1
	 */
	public String getBasicCourse1() {
		return BasicCourse1;
	}
	/**
	 * @param basicCourse1 the basicCourse1 to set
	 */
	public void setBasicCourse1(String basicCourse1) {
		BasicCourse1 = basicCourse1;
	}
	/**
	 * @return the advanceCourse1
	 */
	public String getAdvanceCourse1() {
		return AdvanceCourse1;
	}
	/**
	 * @param advanceCourse1 the advanceCourse1 to set
	 */
	public void setAdvanceCourse1(String advanceCourse1) {
		AdvanceCourse1 = advanceCourse1;
	}
	/**
	 * @return the specialCourse1
	 */
	public String getSpecialCourse1() {
		return SpecialCourse1;
	}
	/**
	 * @param specialCourse1 the specialCourse1 to set
	 */
	public void setSpecialCourse1(String specialCourse1) {
		SpecialCourse1 = specialCourse1;
	}
	
}
