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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="personalInformationTrainee")
public class PersonalInformationTrainee {
	
	
	@Id
    @Column(name="personalInformationTraineeId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
	
	
	 private String checkCompany;
	 private String checkPermanent;
	 public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	private String caste;
	 
	 
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	
	
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="title")
	private Title title;
	
	@NotNull
	@Size(min=1, max=50 , message="enter your FirstName")
	private String FirstName;

	private String MiddleName;
	@NotNull
	@Size(min=1, max=50 , message="enter your LastName ")
	private String  LastName ;

	@NotNull
	@Size(min=1, max=100 , message="enter your father's name")
	private String FatherName;
	
	private String registrationNo;
	
	@NotNull
	@Size(min=12, max=12 , message="enter your AadharNumber ")
	private String  AadharNumber ; 
	 @Email
	private String Email;
	@NotNull
	private String dob;

	@Size(max=10 , message = "enter your mobile Number")
	private String mobile;
	@NotNull
	private String gender;
	@NotNull 
	private int profileCode;
	@NotNull
	@Size(min=1, max=100 , message="enter your ResidentialAddress1 ")
	private String ResidentialLine1; 
	@NotNull 
	@Size(min=1, max=100 , message="enter your ResidentialAddress2")
	private String ResidentialLine2;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="resState")
	private State resState;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="resCity")
	private City resCity;
	
	@NotNull
	@Size(min=1, max=6 , message="enter your Pincode")
	private String resPincode;
	@NotNull
	@Size(min=1, max=100 , message="enter your correspondenceAddress1")
	private String correspondenceAddress1;
	@NotNull
	@Size(min=1, max=100 , message="enter your correspondenceAddress1")
	private String correspondenceAddress2;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="correspondenceState")
	private State correspondenceState;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="correspondenceCity")
	private City correspondenceCity;
	@NotNull @Size(min=6, max=6 , message="* enter your correspondencePincode ")
	private String correspondencePincode;


	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="residentialDistrict")
	private District residentialDistrict;
	@NotNull

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="correspondenceDistrict")
	private District correspondenceDistrict;
	//@NotNull
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="bussDistrict")
	private District bussDistrict;
	
    
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="KindOfBusiness")
	private KindOfBusiness KindOfBusiness;
	//@NotNull @Size(min=1, max=50 , message="enter your Designation")
	//@Column(name="designation")
	private String Designation;
	//@NotNull  @Size(min=1, max=100 , message="enter your BusinessAddress ")
	private String BusinessAddressLine1;
	//@NotNull  @Size(min=1, max=100 , message="enter your BusinessAddress ")
	private String BusinessAddressLine2;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="bussCity")
	private City bussCity;
	//@NotNull @Size(min=6, max=6 , message="enter your bussPincode")
	private String bussPincode;
	// @Size(min=1, max=50 )
	private String CompanyName;

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="bussState")
	private State bussState;

	@Transient
	private boolean checkCorrespondence;
	
	public PersonalInformationTrainee(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCheckCompany() {
		return checkCompany;
	}

	public void setCheckCompany(String checkCompany) {
		this.checkCompany = checkCompany;
	}

	public String getCheckPermanent() {
		return checkPermanent;
	}

	public void setCheckPermanent(String checkPermanent) {
		this.checkPermanent = checkPermanent;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
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

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getAadharNumber() {
		return AadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(int profileCode) {
		this.profileCode = profileCode;
	}

	public String getResidentialLine1() {
		return ResidentialLine1;
	}

	public void setResidentialLine1(String residentialLine1) {
		ResidentialLine1 = residentialLine1;
	}

	public String getResidentialLine2() {
		return ResidentialLine2;
	}

	public void setResidentialLine2(String residentialLine2) {
		ResidentialLine2 = residentialLine2;
	}

	public State getResState() {
		return resState;
	}

	public void setResState(State resState) {
		this.resState = resState;
	}

	public City getResCity() {
		return resCity;
	}

	public void setResCity(City resCity) {
		this.resCity = resCity;
	}

	public String getResPincode() {
		return resPincode;
	}

	public void setResPincode(String resPincode) {
		this.resPincode = resPincode;
	}

	public String getCorrespondenceAddress1() {
		return correspondenceAddress1;
	}

	public void setCorrespondenceAddress1(String correspondenceAddress1) {
		this.correspondenceAddress1 = correspondenceAddress1;
	}

	public String getCorrespondenceAddress2() {
		return correspondenceAddress2;
	}

	public void setCorrespondenceAddress2(String correspondenceAddress2) {
		this.correspondenceAddress2 = correspondenceAddress2;
	}

	public State getCorrespondenceState() {
		return correspondenceState;
	}

	public void setCorrespondenceState(State correspondenceState) {
		this.correspondenceState = correspondenceState;
	}

	public City getCorrespondenceCity() {
		return correspondenceCity;
	}

	public void setCorrespondenceCity(City correspondenceCity) {
		this.correspondenceCity = correspondenceCity;
	}

	public String getCorrespondencePincode() {
		return correspondencePincode;
	}

	public void setCorrespondencePincode(String correspondencePincode) {
		this.correspondencePincode = correspondencePincode;
	}

	public District getResidentialDistrict() {
		return residentialDistrict;
	}

	public void setResidentialDistrict(District residentialDistrict) {
		this.residentialDistrict = residentialDistrict;
	}

	public District getCorrespondenceDistrict() {
		return correspondenceDistrict;
	}

	public void setCorrespondenceDistrict(District correspondenceDistrict) {
		this.correspondenceDistrict = correspondenceDistrict;
	}

	public District getBussDistrict() {
		return bussDistrict;
	}

	public void setBussDistrict(District bussDistrict) {
		this.bussDistrict = bussDistrict;
	}

	public KindOfBusiness getKindOfBusiness() {
		return KindOfBusiness;
	}

	public void setKindOfBusiness(KindOfBusiness kindOfBusiness) {
		KindOfBusiness = kindOfBusiness;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getBusinessAddressLine1() {
		return BusinessAddressLine1;
	}

	public void setBusinessAddressLine1(String businessAddressLine1) {
		BusinessAddressLine1 = businessAddressLine1;
	}

	public String getBusinessAddressLine2() {
		return BusinessAddressLine2;
	}

	public void setBusinessAddressLine2(String businessAddressLine2) {
		BusinessAddressLine2 = businessAddressLine2;
	}

	public City getBussCity() {
		return bussCity;
	}

	public void setBussCity(City bussCity) {
		this.bussCity = bussCity;
	}

	public String getBussPincode() {
		return bussPincode;
	}

	public void setBussPincode(String bussPincode) {
		this.bussPincode = bussPincode;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public State getBussState() {
		return bussState;
	}

	public void setBussState(State bussState) {
		this.bussState = bussState;
	}

	public boolean isCheckCorrespondence() {
		return checkCorrespondence;
	}

	public void setCheckCorrespondence(boolean checkCorrespondence) {
		this.checkCorrespondence = checkCorrespondence;
	}
	
	private int steps;

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
	
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