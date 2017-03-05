package com.ir.model;

import java.io.Serializable;
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

@Entity
@Table(name="personalInformationTrainer")
public class PersonalInformationTrainer implements Serializable {
	
	@Transient
	private boolean checkPermanent;
	private String caste;
	
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public boolean isCheckPermanent() {
		return checkPermanent;
	}
	public void setCheckPermanent(boolean checkPermanent) {
		this.checkPermanent = checkPermanent;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int personalInformationTrainerId;

	
	public int getPersonalInformationTrainerId() {
		return personalInformationTrainerId;
	}
	public void setPersonalInformationTrainerId(int personalInformationTrainerId) {
		this.personalInformationTrainerId = personalInformationTrainerId;
	}
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="correspondencedistrict")
	private District correspondencedistrict;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="correspondencestate")
	private State correspondencestate;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="correspondencecity")
	private City correspondencecity;
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="permanentdistrict")
	private District permanentdistrict;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="permanentstate")
	private State permanentstate;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="permanentcity")
	private City permanentcity;

	private String checkAddress;
	public District getPermanentdistrict() {
		return permanentdistrict;
	}
	public void setPermanentdistrict(District permanentdistrict) {
		this.permanentdistrict = permanentdistrict;
	}
	public State getPermanentstate() {
		return permanentstate;
	}
	public void setPermanentstate(State permanentstate) {
		this.permanentstate = permanentstate;
	}
	public City getPermanentcity() {
		return permanentcity;
	}
	public void setPermanentcity(City permanentcity) {
		this.permanentcity = permanentcity;
	}
	public District getCorrespondencedistrict() {
		return correspondencedistrict;
	}
	public void setCorrespondencedistrict(District correspondencedistrict) {
		this.correspondencedistrict = correspondencedistrict;
	}
	public String getCheckAddress() {
		return checkAddress;
	}
		public void setCheckAddress(String checkAddress) {
		this.checkAddress = checkAddress;
	}
	public State getCorrespondencestate() {
		return correspondencestate;
	}
	public void setCorrespondencestate(State correspondencestate) {
		this.correspondencestate = correspondencestate;
	}
	public City getCorrespondencecity() {
		return correspondencecity;
	}
	public void setCorrespondencecity(City correspondencecity) {
		this.correspondencecity = correspondencecity;
	}
	
	
	

	public Title getTitle() {
		return Title;
	}
	public void setTitle(Title title) {
		Title = title;
	}
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="title")
	private Title Title;
	@NotNull @Size(min=12, max=12 , message="* error")
	private String AadharNumber;
	@NotNull @Size(min=1, max=50 , message="* error")
	private String FirstName;
	//@NotNull @Size(min=1, max=20 , message="* error")
	private String MiddleName;
	@NotNull @Size(min=1, max=50 , message="* error")
	private String LastName;
	@NotNull @Size(min=1, max=50 , message="* error")
	private String fathername;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String DOB;
	@NotNull @Size(min=1, max=20 , message="* error")
	private String gender;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String TrainingCenterPermanentLine1;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String TrainingCenterPermanentLine2;
//	@NotNull
	private int TrainingCenterPermanentState;
//	@NotNull
	private int TrainingCenterPermanentDistrict;
//	@NotNull
	private int TrainingCenterPermanentCity;
	@NotNull @Size(min=1, max=20 , message="* error")
	private String TrainingCenterPermanentPincode;
	//@NotNull @Email(message="& error")
	private String TrainingCenterPermanentEmail;
	//@NotNull @Size(min=10, max=10 , message="* error")
	private String TrainingCenterPermanentMobile;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String TrainingCenterCorrespondenceLine1;
	@NotNull @Size(min=1, max=100 , message="* error")
	private String TrainingCenterCorrespondenceLine2;
	/*@NotNull
	private int TrainingCenterCorrespondenceState;
	@NotNull
	private int TrainingCenterCorrespondenceDistrict;
	@NotNull
	private int TrainingCenterCorrespondenceCity;*/
	@NotNull @Size(min=6, max=6 , message="* error")
	private String TrainingCenterCorrespondencePincode;
	@NotNull
	private String FoodSafetyExpBackground;
	@NotNull 
	private int TrainingSessionWishToConduct;
	@NotNull
	private int ExpInFoodSafefyTimeYear;
	@NotNull 
	private int ExpInFoodSafefyTimeMonth;
	@NotNull
	private String AssociatedWithAnyTrainingPartner;
	@NotNull
	private int NoOfTrainingSessionConducted;
	@Column(columnDefinition="int default 0")
	private int steps;
	
	public int getTrainingCenterPermanentState() {
		return TrainingCenterPermanentState;
	}
	public void setTrainingCenterPermanentState(int trainingCenterPermanentState) {
		TrainingCenterPermanentState = trainingCenterPermanentState;
	}
	public int getTrainingCenterPermanentDistrict() {
		return TrainingCenterPermanentDistrict;
	}
	public void setTrainingCenterPermanentDistrict(
			int trainingCenterPermanentDistrict) {
		TrainingCenterPermanentDistrict = trainingCenterPermanentDistrict;
	}
	public int getTrainingCenterPermanentCity() {
		return TrainingCenterPermanentCity;
	}
	public void setTrainingCenterPermanentCity(int trainingCenterPermanentCity) {
		TrainingCenterPermanentCity = trainingCenterPermanentCity;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="AssociatedTrainingpartnerName")
	private ManageTrainingPartner AssociatedTrainingpartnerName;
	//@NotNull
	private String BasicCourse;
	//@NotNull
	private String AdvanceCourse;
	//@NotNull
	private String SpecialCourse;
	
	public ManageTrainingPartner getAssociatedTrainingpartnerName() {
		return AssociatedTrainingpartnerName;
	}
	public void setAssociatedTrainingpartnerName(ManageTrainingPartner associatedTrainingpartnerName) {
		AssociatedTrainingpartnerName = associatedTrainingpartnerName;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
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
	public String getTrainingCenterPermanentLine1() {
		return TrainingCenterPermanentLine1;
	}
	public void setTrainingCenterPermanentLine1(String trainingCenterPermanentLine1) {
		TrainingCenterPermanentLine1 = trainingCenterPermanentLine1;
	}
	public String getTrainingCenterPermanentLine2() {
		return TrainingCenterPermanentLine2;
	}
	public void setTrainingCenterPermanentLine2(String trainingCenterPermanentLine2) {
		TrainingCenterPermanentLine2 = trainingCenterPermanentLine2;
	}
/*	public int getTrainingCenterPermanentState() {
		return TrainingCenterPermanentState;
	}
	public void setTrainingCenterPermanentState(int trainingCenterPermanentState) {
		TrainingCenterPermanentState = trainingCenterPermanentState;
	}
	public int getTrainingCenterPermanentDistrict() {
		return TrainingCenterPermanentDistrict;
	}
	public void setTrainingCenterPermanentDistrict(int trainingCenterPermanentDistrict) {
		TrainingCenterPermanentDistrict = trainingCenterPermanentDistrict;
	}
	public int getTrainingCenterPermanentCity() {
		return TrainingCenterPermanentCity;
	}
	public void setTrainingCenterPermanentCity(int trainingCenterPermanentCity) {
		TrainingCenterPermanentCity = trainingCenterPermanentCity;
	}*/
	public String getTrainingCenterPermanentPincode() {
		return TrainingCenterPermanentPincode;
	}
	public void setTrainingCenterPermanentPincode(String trainingCenterPermanentPincode) {
		TrainingCenterPermanentPincode = trainingCenterPermanentPincode;
	}
	public String getTrainingCenterPermanentEmail() {
		return TrainingCenterPermanentEmail;
	}
	public void setTrainingCenterPermanentEmail(String trainingCenterPermanentEmail) {
		TrainingCenterPermanentEmail = trainingCenterPermanentEmail;
	}
	public String getTrainingCenterPermanentMobile() {
		return TrainingCenterPermanentMobile;
	}
	public void setTrainingCenterPermanentMobile(String trainingCenterPermanentMobile) {
		TrainingCenterPermanentMobile = trainingCenterPermanentMobile;
	}
	public String getTrainingCenterCorrespondenceLine1() {
		return TrainingCenterCorrespondenceLine1;
	}
	public void setTrainingCenterCorrespondenceLine1(String trainingCenterCorrespondenceLine1) {
		TrainingCenterCorrespondenceLine1 = trainingCenterCorrespondenceLine1;
	}
	public String getTrainingCenterCorrespondenceLine2() {
		return TrainingCenterCorrespondenceLine2;
	}
	public void setTrainingCenterCorrespondenceLine2(String trainingCenterCorrespondenceLine2) {
		TrainingCenterCorrespondenceLine2 = trainingCenterCorrespondenceLine2;
	}
	/*public int getTrainingCenterCorrespondenceState() {
		return TrainingCenterCorrespondenceState;
	}
	public void setTrainingCenterCorrespondenceState(int trainingCenterCorrespondenceState) {
		TrainingCenterCorrespondenceState = trainingCenterCorrespondenceState;
	}
	public int getTrainingCenterCorrespondenceDistrict() {
		return TrainingCenterCorrespondenceDistrict;
	}
	public void setTrainingCenterCorrespondenceDistrict(int trainingCenterCorrespondenceDistrict) {
		TrainingCenterCorrespondenceDistrict = trainingCenterCorrespondenceDistrict;
	}
	public int getTrainingCenterCorrespondenceCity() {
		return TrainingCenterCorrespondenceCity;
	}
	public void setTrainingCenterCorrespondenceCity(int trainingCenterCorrespondenceCity) {
		TrainingCenterCorrespondenceCity = trainingCenterCorrespondenceCity;
	}*/
	public String getTrainingCenterCorrespondencePincode() {
		return TrainingCenterCorrespondencePincode;
	}
	public void setTrainingCenterCorrespondencePincode(String trainingCenterCorrespondencePincode) {
		TrainingCenterCorrespondencePincode = trainingCenterCorrespondencePincode;
	}
	public String getFoodSafetyExpBackground() {
		return FoodSafetyExpBackground;
	}
	public void setFoodSafetyExpBackground(String foodSafetyExpBackground) {
		FoodSafetyExpBackground = foodSafetyExpBackground;
	}
	public int getTrainingSessionWishToConduct() {
		return TrainingSessionWishToConduct;
	}
	public void setTrainingSessionWishToConduct(int trainingSessionWishToConduct) {
		TrainingSessionWishToConduct = trainingSessionWishToConduct;
	}
	public int getExpInFoodSafefyTimeYear() {
		return ExpInFoodSafefyTimeYear;
	}
	public void setExpInFoodSafefyTimeYear(int expInFoodSafefyTimeYear) {
		ExpInFoodSafefyTimeYear = expInFoodSafefyTimeYear;
	}
	public int getExpInFoodSafefyTimeMonth() {
		return ExpInFoodSafefyTimeMonth;
	}
	public void setExpInFoodSafefyTimeMonth(int expInFoodSafefyTimeMonth) {
		ExpInFoodSafefyTimeMonth = expInFoodSafefyTimeMonth;
	}
	public String getAssociatedWithAnyTrainingPartner() {
		return AssociatedWithAnyTrainingPartner;
	}
	public void setAssociatedWithAnyTrainingPartner(String associatedWithAnyTrainingPartner) {
		AssociatedWithAnyTrainingPartner = associatedWithAnyTrainingPartner;
	}
	public int getNoOfTrainingSessionConducted() {
		return NoOfTrainingSessionConducted;
	}
	public void setNoOfTrainingSessionConducted(int noOfTrainingSessionConducted) {
		NoOfTrainingSessionConducted = noOfTrainingSessionConducted;
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
