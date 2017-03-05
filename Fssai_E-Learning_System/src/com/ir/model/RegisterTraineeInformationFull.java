package com.ir.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="traineeRegistration")
public class RegisterTraineeInformationFull {
	
	@NotEmpty
	private Integer UserId;
	@NotEmpty
	private List<Title> title;
	@NotEmpty @Min(2) @Max(20)
	private String FirstName;
	@NotEmpty @Min(2) @Max(20)
	private String  MiddleName ;
	@NotEmpty @Min(2) @Max(20)
	private String  LastName ;
	@NotEmpty @Min(2) @Max(20)
	private String Password;
	@NotEmpty @Min(2) @Max(20)
	private String  AadharNumber ; 
	@NotEmpty @Email
	private String Email;
	@NotEmpty
	private String dob;
	@NotEmpty @Size(min=10, max=10)
	private int mobile;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String profileCode;
	@NotEmpty @Min(2) @Max(20)
	private String ResidentialAddressLine1; 
	@NotEmpty @Min(2) @Max(20)
	private String ResidentialAddressLine2;
	@NotEmpty
	private List<State> resState;
	@NotEmpty
	private List<City> resCity;
	@NotEmpty
	private String resLocation;
	@NotEmpty
	private String resPincode;
	@NotEmpty
	private List<KindOfBusiness> KindOfBusiness;
	//@NotEmpty
	private String Designation;
	//@NotEmpty
	private String BusinessAddressLine1;
	//@NotEmpty
	private String BusinessAddressLine2;
	//@NotEmpty
	private String bussCity;
	//@NotEmpty
	private String bussPincode;
	//@NotEmpty
	private String CompanyName;
	//@NotEmpty
	private String bussState;
	//@NotEmpty
	private String bussLocation;
	
	
	public String getBussLocation() {
		return bussLocation;
	}
	public void setBussLocation(String bussLocation) {
		this.bussLocation = bussLocation;
	}
	public String getBussState() {
		return bussState;
	}
	public void setBussState(String bussState) {
		this.bussState = bussState;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getBussPincode() {
		return bussPincode;
	}
	public void setBussPincode(String bussPincode) {
		this.bussPincode = bussPincode;
	}
	public String getBussCity() {
		return bussCity;
	}
	public void setBussCity(String bussCity) {
		this.bussCity = bussCity;
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
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public List<KindOfBusiness> getKindOfBusiness() {
		return KindOfBusiness;
	}
	public void setKindOfBusiness(List<KindOfBusiness> kindOfBusiness) {
		KindOfBusiness = kindOfBusiness;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public List<Title> getTitle() {
		return title;
	}
	public void setTitle(List<Title> title) {
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
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfileCode() {
		return profileCode;
	}
	public void setProfileCode(String profileCode) {
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
	public List<State> getResState() {
		return resState;
	}
	public void setResState(List<State> resState) {
		this.resState = resState;
	}
	public List<City> getResCity() {
		return resCity;
	}
	public void setResCity(List<City> resCity) {
		this.resCity = resCity;
	}
	public String getResLocation() {
		return resLocation;
	}
	public void setResLocation(String resLocation) {
		this.resLocation = resLocation;
	}
	public String getResPincode() {
		return resPincode;
	}
	public void setResPincode(String resPincode) {
		this.resPincode = resPincode;
	}
	@Override
	public String toString() {
		return "RegisterTraineeInformationFull [UserId=" + UserId + ", title=" + title + ", FirstName=" + FirstName
				+ ", MiddleName=" + MiddleName + ", LastName=" + LastName + ", Password=" + Password + ", AadharNumber="
				+ AadharNumber + ", Email=" + Email + ", dob=" + dob + ", mobile=" + mobile + ", gender=" + gender
				+ ", profileCode=" + profileCode + ", ResidentialAddressLine1=" + ResidentialAddressLine1
				+ ", ResidentialAddressLine2=" + ResidentialAddressLine2 + ", resState=" + resState + ", resCity="
				+ resCity + ", resLocation=" + resLocation + ", resPincode=" + resPincode + ", KindOfBusiness="
				+ KindOfBusiness + ", Designation=" + Designation + ", BusinessAddressLine1=" + BusinessAddressLine1
				+ ", BusinessAddressLine2=" + BusinessAddressLine2 + ", bussCity=" + bussCity + ", bussPincode="
				+ bussPincode + ", CompanyName=" + CompanyName + ", bussState=" + bussState + ", bussLocation="
				+ bussLocation + "]";
	}
	
	
}
