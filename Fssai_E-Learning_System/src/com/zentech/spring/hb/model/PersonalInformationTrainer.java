package com.zentech.spring.hb.model;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



@Entity
@Table(name="PERSONALINFORMATIONTRAINER")
public class PersonalInformationTrainer {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "PERSONALINFOTRAINEE_SEQ", allocationSize=1, initialValue=1)
	private int id;
	
	@NotNull
	
	private int userType;
	
	@NotNull
	@Size(min=1, max=50 , message="Select Induction Trainee")
	private String inductionTrainee;
	
	
	 public int getUserType() {
		return userType;
	}

	public void setUserType(int i) {
		this.userType = i;
	}

	public String getInductionTrainee() {
		return inductionTrainee;
	}

	public void setInductionTrainee(String inductionTrainee) {
		this.inductionTrainee = inductionTrainee;
	}

	private String checkCompany;
	 private String checkPermanent;

	private String title;
	
	
	@NotNull
	
	@Size(min=1, max=50 , message="enter your FirstName")
	private String firstName;

	private String MiddleName;
	@NotNull
	@Size(min=1, max=50 , message="enter your LastName ")
	private String  LastName ;

	@NotNull
	@Size(min=1, max=100 , message="enter your father's name")
	private String FatherName;
	
	
	
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

	
	private String resState;

	
	private String resCity;
	
	@NotNull
	@Size(min=1, max=6 , message="enter your Pincode")
	private String resPincode;
	@NotNull
	@Size(min=1, max=100 , message="enter your correspondenceAddress1")
	private String correspondenceAddress1;
	@NotNull
	@Size(min=1, max=100 , message="enter your correspondenceAddress1")
	private String correspondenceAddress2;

	
	private String correspondenceState;
	
	private String correspondenceCity;
	@NotNull @Size(min=6, max=6 , message="* enter your correspondencePincode ")
	private String correspondencePincode;


	private String residentialDistrict;
	@NotNull


	private String correspondenceDistrict;
	//@NotNull
	
	

	@Transient
	private boolean checkCorrespondence;
	
	
	@NotNull
	private String FoodSafetyExpBackground;
	@NotNull 
	private int TrainingSessionWishToConduct;
	@NotNull
	private int ExpInFoodSafefyTimeYear;
	@NotNull 
	private int ExpInFoodSafefyTimeMonth;
	@NotNull
	private String AssociatedWithAnyTrainingInstitute;
	@NotNull
	private int NoOfTrainingSessionConducted;
	
	

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

	public String getAssociatedWithAnyTrainingInstitute() {
		return AssociatedWithAnyTrainingInstitute;
	}

	public void setAssociatedWithAnyTrainingInstitute(
			String associatedWithAnyTrainingInstitute) {
		AssociatedWithAnyTrainingInstitute = associatedWithAnyTrainingInstitute;
	}

	public int getNoOfTrainingSessionConducted() {
		return NoOfTrainingSessionConducted;
	}

	public void setNoOfTrainingSessionConducted(int noOfTrainingSessionConducted) {
		NoOfTrainingSessionConducted = noOfTrainingSessionConducted;
	}

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

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		this.MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		this.FatherName = fatherName;
	}



	public String getAadharNumber() {
		return AadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.AadharNumber = aadharNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
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
		this.ResidentialLine1 = residentialLine1;
	}

	public String getResidentialLine2() {
		return ResidentialLine2;
	}

	public void setResidentialLine2(String residentialLine2) {
		this.ResidentialLine2 = residentialLine2;
	}

	public String getResState() {
		return resState;
	}

	public void setResState(String resState) {
		this.resState = resState;
	}

	public String getResCity() {
		return resCity;
	}

	public void setResCity(String resCity) {
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

	public String getCorrespondenceState() {
		return correspondenceState;
	}

	public void setCorrespondenceState(String correspondenceState) {
		this.correspondenceState = correspondenceState;
	}

	public String getCorrespondenceCity() {
		return correspondenceCity;
	}

	public void setCorrespondenceCity(String correspondenceCity) {
		this.correspondenceCity = correspondenceCity;
	}

	public String getCorrespondencePincode() {
		return correspondencePincode;
	}

	public void setCorrespondencePincode(String correspondencePincode) {
		this.correspondencePincode = correspondencePincode;
	}

	public String getResidentialDistrict() {
		return residentialDistrict;
	}

	public void setResidentialDistrict(String residentialDistrict) {
		this.residentialDistrict = residentialDistrict;
	}

	public String getCorrespondenceDistrict() {
		return correspondenceDistrict;
	}

	public void setCorrespondenceDistrict(String correspondenceDistrict) {
		this.correspondenceDistrict = correspondenceDistrict;
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

	@Override
	public String toString() {
		return "PersonalInformationTrainee [id=" + id + ", FirstName=" + firstName + ", mobile=" + mobile +  ", Email="+Email +" , AadharNumber="+AadharNumber+   "]";
	}
	
}
