package com.ir.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="personalInformationAssessor")
public class PersonalInformationAssessor {
	
	
	@Id
	@Column(name="personalInformationAssessorId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//private int personalInformationAssessorId;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	

	private String  userId;
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="Title")
	private Title Title;
	@NotNull @Size(min=12, max=12 , message="* error")
	private String AadharNumber;
	@NotNull @Size(min=1, max=20 , message="* error")
	private String FirstName;
	//@NotNull @Size(min=1, max=20 , message="* error")
	private String MiddleName;
	@NotNull @Size(min=1, max=20 , message="* error")
	private String LastName;
	@NotNull @Size(min=1, max=20 , message="* error")
	private String DOB;
	@NotNull @Size(min=1, max=20 , message="* error")
	private String gender;
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessmentAgencyName")
	private ManageAssessmentAgency AssessmentAgencyName;
	
	@NotNull @Size(min=1, max=100 , message="* error")
	private String AssessorPermanentLine1;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String AssessorPermanentLine2;
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessorrPermanentState")
	private State AssessorrPermanentState;
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessorPermanentDistrict")
	private District AssessorPermanentDistrict;
	
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessorPermanentCity")
	private City AssessorPermanentCity;

	@NotNull @Size(min=1, max=20 , message="* error")
	private String AssessorPermanentPincode;
	@NotNull @Email(message="& error")
	private String AssessorPermanentEmail;
	@NotNull @Size(min=10, max=10 , message="* error")
	private String AssessorPermanentMobile;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String AssessorCorrespondenceLine1;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String AssessorCorrespondenceLine2;
	
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessorCorrespondenceState")
	private State AssessorCorrespondenceState;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessorCorrespondenceDistrict")
	private District AssessorCorrespondenceDistrict;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssessorCorrespondenceCity")
	private City AssessorCorrespondenceCity;

	@NotNull @Size(min=6, max=6 , message="* error")
	private String AssessorCorrespondencePincode;
	@NotNull
	private int ReleventExpOfAuditInYear;
	@NotNull
	private String ReleventExpOfAuditInMonth;
	@NotNull
	private String HowManyAssessmentConductInAMonth;
	
//	@OneToMany (cascade=CascadeType.ALL)  @JoinColumn(name="courseEnrolled")
//	private List<CourseEnrolled> coursesEnrolled;
	
	public PersonalInformationAssessor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getAssessorPermanentLine1() {
		return AssessorPermanentLine1;
	}
	public void setAssessorPermanentLine1(String assessorPermanentLine1) {
		AssessorPermanentLine1 = assessorPermanentLine1;
	}
	public String getAssessorPermanentLine2() {
		return AssessorPermanentLine2;
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
	
	public Title getTitle() {
		return Title;
	}
	public void setTitle(Title title) {
		Title = title;
	}
	public ManageAssessmentAgency getAssessmentAgencyName() {
		return AssessmentAgencyName;
	}
	public void setAssessmentAgencyName(ManageAssessmentAgency assessmentAgencyName) {
		AssessmentAgencyName = assessmentAgencyName;
	}
	public State getAssessorrPermanentState() {
		return AssessorrPermanentState;
	}
	public void setAssessorrPermanentState(State assessorrPermanentState) {
		AssessorrPermanentState = assessorrPermanentState;
	}
	public District getAssessorPermanentDistrict() {
		return AssessorPermanentDistrict;
	}
	public void setAssessorPermanentDistrict(District assessorPermanentDistrict) {
		AssessorPermanentDistrict = assessorPermanentDistrict;
	}
	public City getAssessorPermanentCity() {
		return AssessorPermanentCity;
	}
	public void setAssessorPermanentCity(City assessorPermanentCity) {
		AssessorPermanentCity = assessorPermanentCity;
	}
	public State getAssessorCorrespondenceState() {
		return AssessorCorrespondenceState;
	}
	public void setAssessorCorrespondenceState(State assessorCorrespondenceState) {
		AssessorCorrespondenceState = assessorCorrespondenceState;
	}
	public District getAssessorCorrespondenceDistrict() {
		return AssessorCorrespondenceDistrict;
	}
	public void setAssessorCorrespondenceDistrict(District assessorCorrespondenceDistrict) {
		AssessorCorrespondenceDistrict = assessorCorrespondenceDistrict;
	}
	public City getAssessorCorrespondenceCity() {
		return AssessorCorrespondenceCity;
	}
	public void setAssessorCorrespondenceCity(City assessorCorrespondenceCity) {
		AssessorCorrespondenceCity = assessorCorrespondenceCity;
	}
	public void setAssessorPermanentLine2(String assessorPermanentLine2) {
		AssessorPermanentLine2 = assessorPermanentLine2;
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
	/**
	 * @return the coursesEnrolled
	 */
//	public List<CourseEnrolled> getCoursesEnrolled() {
//		return coursesEnrolled;
//	}
	/**
	 * @param coursesEnrolled the coursesEnrolled to set
	 */
//	public void setCoursesEnrolled(List<CourseEnrolled> coursesEnrolled) {
//		this.coursesEnrolled = coursesEnrolled;
//	}
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}