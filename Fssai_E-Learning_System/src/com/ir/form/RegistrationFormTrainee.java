package com.ir.form;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class RegistrationFormTrainee {
	
	//@NotNull
	//@Size(min=1, max=20 , message="enter your userId")
	private String UserId;
	@NotNull
	private int title;
	@NotNull
	@Size(min=1, max=50 , message="enter FirstName") 
	private String FirstName;
	
	/*@NotNull*/
//	@Size(min=0, max=50 , message="")
	private String  MiddleName ;
	@NotNull
	@Size(min=1, max=50 , message="enter your LastName")
	private String  LastName ;
	
	@NotNull
	@Size(min=1, max=100 , message="enter your father's name")
	private String FatherName;
	private String Password="Password";
	@NotNull
	@Size(min=12, max=12 , message="enter your AAdhar Number")
	private String  AadharNumber ; 
	 @Email(message="enter your Email")
	private String Email;
	//@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull //@Past
	private String dob;
    private boolean checkCompany;
    @Size(max=10 , message = "enter your mobile Number")
	private String mobile;
	@NotEmpty	@Size(min=1, max=1 , message="Please select gender")
	private String gender;
	@NotNull
	private int profileCode;
	@NotNull  
	@Size(min=1, max=100 , message="enter your ResidentialAddress1 ")
	private String ResidentialAddressLine1; 
	@NotNull  @Size(min=1, max=100 , message="enter your ResidentialAddress2")
	private String ResidentialAddressLine2;
	@NotNull
	private int resState;
	@NotNull 
	private int resCity;
	@NotNull
	private int residentialDistrict;
	@NotNull @Size(min=6, max=6 , message="enter your Pincode")
	private String resPincode;
	//@NotNull
	private int KindOfBusiness;
	//@NotNull @Size(min=1, max=20 , message="Please enter your designation")
	private String Designation;
	//@NotNull @Size(min=1, max=100 , message="enter your BusinessAddress ")
	private String BusinessAddressLine1;
    //@NotNull @Size(min=1, max=100 , message="* enter your BusinessAddress ")
	private String BusinessAddressLine2;
	//@NotNull
	private int bussCity;
    //@NotNull @Size(min=6, max=6 , message="enter your bussPincode")
	private String bussPincode;
	private boolean checkCorrespondence;
	private String CompanyName;
   // @NotNull
	private int bussState;
	private String registrationNo;
	@NotNull @Size(min=1, max=100 , message="* enter your correspondenceAddress1 ")
	private String correspondenceAddress1;
	@NotNull @Size(min=1, max=100 , message="* enter your correspondenceAddress2 ")
	private String correspondenceAddress2;

	@NotNull
	private int correspondenceState;
	@NotNull
	private int correspondenceCity;
	@NotNull @Size(min=6, max=6 , message="* enter your Pincode")
	private String correspondencePincode;

	@NotNull
	private int correspondenceDistrict;
	
	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	private String caste;
	
//	@NotNull
	private int bussDistrict;
	/**Constructor */
	public RegistrationFormTrainee(){
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	private String captcha="jhgjhjh";

	public int getResidentialDistrict() {
		return residentialDistrict;
	}

	public void setResidentialDistrict(int residentialDistrict) {
		this.residentialDistrict = residentialDistrict;
	}

	public int getCorrespondenceDistrict() {
		return correspondenceDistrict;
	}

	public void setCorrespondenceDistrict(int correspondenceDistrict) {
		this.correspondenceDistrict = correspondenceDistrict;
	}

	public int getBussDistrict() {
		return bussDistrict;
	}

	public void setBussDistrict(int bussDistrict) {
		this.bussDistrict = bussDistrict;
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

	public int getCorrespondenceState() {
		return correspondenceState;
	}

	public void setCorrespondenceState(int correspondenceState) {
		this.correspondenceState = correspondenceState;
	}

	public int getCorrespondenceCity() {
		return correspondenceCity;
	}

	public void setCorrespondenceCity(int correspondenceCity) {
		this.correspondenceCity = correspondenceCity;
	}

	public String getCorrespondencePincode() {
		return correspondencePincode;
	}

	public void setCorrespondencePincode(String correspondencePincode) {
		this.correspondencePincode = correspondencePincode;
	}

	

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAadharNumber() {
		return AadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
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

	public boolean isCheckCompany() {
		return checkCompany;
	}
	public void setCheckCompany(boolean checkCompany) {
		this.checkCompany = checkCompany;
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

	public String getResidentialAddressLine1() {
		return ResidentialAddressLine1;
	}

	public void setResidentialAddressLine1(String residentialAddressLine1) {
		ResidentialAddressLine1 = residentialAddressLine1;
	}

	public String getResidentialAddressLine2() {
		return ResidentialAddressLine2;
	}

	public void setResidentialAddressLine2(String residentialAddressLine2) {
		ResidentialAddressLine2 = residentialAddressLine2;
	}

	public int getResState() {
		return resState;
	}

	public void setResState(int resState) {
		this.resState = resState;
	}

	public int getResCity() {
		return resCity;
	}

	public void setResCity(int resCity) {
		this.resCity = resCity;
	}

	
	public String getResPincode() {
		return resPincode;
	}

	public void setResPincode(String resPincode) {
		this.resPincode = resPincode;
	}

	public int getKindOfBusiness() {
		return KindOfBusiness;
	}

	public void setKindOfBusiness(int kindOfBusiness) {
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

	public int getBussCity() {
		return bussCity;
	}

	public void setBussCity(int bussCity) {
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

	public int getBussState() {
		return bussState;
	}

	public void setBussState(int bussState) {
		this.bussState = bussState;
	}

	

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	private int steps;
	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
	public boolean isCheckCorrespondence() {
		
		return checkCorrespondence;
	}

	public void setCheckCorrespondence(boolean checkCorrespondence) {
		this.checkCorrespondence = checkCorrespondence;
	}
	
}