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
@Table(name="personalInformationTrainingPartner")
public class PersonalInformationTrainingPartner {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int personalInformationTrainingPartnerId;
	
	private String userID;

	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	
	
	
	
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	@NotNull
	private int Title;
	@NotNull @Size(min=1, max=50 , message="* Enter Training Centre Name")
	private String TrainingCentreName;
	@NotNull(message="* Enter Training Partner Name")
	private int TrainingPartnerName;
	@NotNull @Size(min=1, max=50 , message="* Enter First Name")
	private String FirstName;
	private String MiddleName;
	@NotNull @Size(min=1, max=50 , message="* Enter Last Name")
	private String LastName;
	@NotNull @Size(min=10, max=50 , message="* Invalid PAN Number")
	private String PAN;
	@NotNull @Size(min=1, max=100 , message="* Enter Training Center Address")
	private String TrainingPartnerPermanentLine1;
	@Size(min=1, max=100 , message="* Enter Training Center Address")
	private String TrainingPartnerPermanentLine2;
	@NotNull(message="* Select State")
	private int TrainingPartnerPermanentState;
	@NotNull(message="* Select District")
	private int TrainingPartnerPermanentDistrict;
	@NotNull(message="* Select City")
	private int TrainingPartnerPermanentCity;
	@NotNull @Size(min=6, max=6 , message="* Enter Valid PIN Code")
	private String TrainingPartnerPermanentPincode;
	@Email(message="* Enter Valid Email Id")
	private String TrainingPartnerPermanentEmail;
  //@NotNull @Size(min=10, max=10 , message="* Enter Mobile Number")
	private String TrainingPartnerPermanentMobile;
	@NotNull @Size(min=1, max=4 , message="* Enter Seating Capacity Per Session")
	private String SeatCapacityPerSession;
/*	@NotNull @Size(min=1, max=4 , message="* Enter Number Of In-House Trainer")
	private String NoOfInHouseTrainers;*/
	@NotNull @Size(min=1, max=4 , message="* Enter Availabilty Of TV Projectors")
	private String AvailabiltyOfTVProjector;
	/*@NotNull @Size(min=1, max=2 , message="* Enter Number Of Years In Business Of Training")
	private String NoOfYearsInBusinessOfTraining;*/
	@NotNull @Size(min=1, max=3 , message="* Enter Availabilty Of In-House Trainers In Food Safety")
	private String AvailabiltyOfInHouseTrainersInFoodSafety;
	/*@NotNull @Size(min=1, max=2 , message="* Enter Number Of Training Session Wish To Conduct In A Month")
	private String NoOfTrainingSessionWishToConductInAMonth;*/

	
	@NotNull @Size(min=1, max=1 , message="* Enter Facility of Electricity + Air-Conditioner ")
	@Column(columnDefinition="varchar(1) default ''")
	private String FacilityOfElectricityAndAirCondition;
	
	@NotNull @Size(min=1, max=1 , message="* Facility of Drinking Water")
	@Column(columnDefinition="varchar(1) default ''")
	private String FacilityOfDrinkingWater;
	
	@NotNull @Size(min=1, max=1 , message="* Enter Facility of Washroom ")
	@Column(columnDefinition="varchar(1) default ''")
	private String FacilityOfWashroom;

	
	public String getFacilityOfElectricityAndAirCondition() {
		return FacilityOfElectricityAndAirCondition;
	}
	public void setFacilityOfElectricityAndAirCondition(
			String facilityOfElectricityAndAirCondition) {
		FacilityOfElectricityAndAirCondition = facilityOfElectricityAndAirCondition;
	}
	public String getFacilityOfDrinkingWater() {
		return FacilityOfDrinkingWater;
	}
	public void setFacilityOfDrinkingWater(String facilityOfDrinkingWater) {
		FacilityOfDrinkingWater = facilityOfDrinkingWater;
	}
	public String getFacilityOfWashroom() {
		return FacilityOfWashroom;
	}
	public void setFacilityOfWashroom(String facilityOfWashroom) {
		FacilityOfWashroom = facilityOfWashroom;
	}

	private int seatcapacityAvailable;
	
	private String TrainingPartnerPermanentLandLine;
	
	
	public String getTrainingPartnerPermanentLandLine() {
		return TrainingPartnerPermanentLandLine;
	}
	public void setTrainingPartnerPermanentLandLine(
			String trainingPartnerPermanentLandLine) {
		TrainingPartnerPermanentLandLine = trainingPartnerPermanentLandLine;
	}
	public int getSeatcapacityAvailable() {
		return seatcapacityAvailable;
	}
	public void setSeatcapacityAvailable(int seatcapacityAvailable) {
		this.seatcapacityAvailable = seatcapacityAvailable;
	}
	private int profileCode;
	
	public int getProfileCode() {
		return profileCode;
	}
	public void setProfileCode(int profileCode) {
		this.profileCode = profileCode;
	}
	public int getPersonalInformationTrainingPartnerId() {
		return personalInformationTrainingPartnerId;
	}
	public void setPersonalInformationTrainingPartnerId(int personalInformationTrainingPartnerId) {
		this.personalInformationTrainingPartnerId = personalInformationTrainingPartnerId;
	}
	public int getTitle() {
		return Title;
	}
	public void setTitle(int title) {
		Title = title;
	}
	public int getTrainingPartnerName() {
		return TrainingPartnerName;
	}
	public void setTrainingPartnerName(int trainingPartnerName) {
		TrainingPartnerName = trainingPartnerName;
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
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	
	public String getTrainingCentreName() {
		return TrainingCentreName;
	}
	public void setTrainingCentreName(String trainingCentreName) {
		TrainingCentreName = trainingCentreName;
	}
	public String getTrainingPartnerPermanentLine1() {
		return TrainingPartnerPermanentLine1;
	}
	public void setTrainingPartnerPermanentLine1(String trainingPartnerPermanentLine1) {
		TrainingPartnerPermanentLine1 = trainingPartnerPermanentLine1;
	}
	public String getTrainingPartnerPermanentLine2() {
		return TrainingPartnerPermanentLine2;
	}
	public void setTrainingPartnerPermanentLine2(String trainingPartnerPermanentLine2) {
		TrainingPartnerPermanentLine2 = trainingPartnerPermanentLine2;
	}
	public int getTrainingPartnerPermanentState() {
		return TrainingPartnerPermanentState;
	}
	public void setTrainingPartnerPermanentState(int trainingPartnerPermanentState) {
		TrainingPartnerPermanentState = trainingPartnerPermanentState;
	}
	public int getTrainingPartnerPermanentDistrict() {
		return TrainingPartnerPermanentDistrict;
	}
	public void setTrainingPartnerPermanentDistrict(int trainingPartnerPermanentDistrict) {
		TrainingPartnerPermanentDistrict = trainingPartnerPermanentDistrict;
	}
	public int getTrainingPartnerPermanentCity() {
		return TrainingPartnerPermanentCity;
	}
	public void setTrainingPartnerPermanentCity(int trainingPartnerPermanentCity) {
		TrainingPartnerPermanentCity = trainingPartnerPermanentCity;
	}
	public String getTrainingPartnerPermanentPincode() {
		return TrainingPartnerPermanentPincode;
	}
	public void setTrainingPartnerPermanentPincode(String trainingPartnerPermanentPincode) {
		TrainingPartnerPermanentPincode = trainingPartnerPermanentPincode;
	}
	public String getTrainingPartnerPermanentEmail() {
		return TrainingPartnerPermanentEmail;
	}
	public void setTrainingPartnerPermanentEmail(String trainingPartnerPermanentEmail) {
		TrainingPartnerPermanentEmail = trainingPartnerPermanentEmail;
	}
	public String getTrainingPartnerPermanentMobile() {
		return TrainingPartnerPermanentMobile;
	}
	public void setTrainingPartnerPermanentMobile(String trainingPartnerPermanentMobile) {
		TrainingPartnerPermanentMobile = trainingPartnerPermanentMobile;
	}
	public String getSeatCapacityPerSession() {
		return SeatCapacityPerSession;
	}
	public void setSeatCapacityPerSession(String seatCapacityPerSession) {
		SeatCapacityPerSession = seatCapacityPerSession;
	}
/*	public String getNoOfInHouseTrainers() {
		return NoOfInHouseTrainers;
	}
	public void setNoOfInHouseTrainers(String noOfInHouseTrainers) {
		NoOfInHouseTrainers = noOfInHouseTrainers;
	}*/
	public String getAvailabiltyOfTVProjector() {
		return AvailabiltyOfTVProjector;
	}
	public void setAvailabiltyOfTVProjector(String availabiltyOfTVProjector) {
		AvailabiltyOfTVProjector = availabiltyOfTVProjector;
	}
/*	public String getNoOfYearsInBusinessOfTraining() {
		return NoOfYearsInBusinessOfTraining;
	}
	public void setNoOfYearsInBusinessOfTraining(String noOfYearsInBusinessOfTraining) {
		NoOfYearsInBusinessOfTraining = noOfYearsInBusinessOfTraining;
	}*/
	public String getAvailabiltyOfInHouseTrainersInFoodSafety() {
		return AvailabiltyOfInHouseTrainersInFoodSafety;
	}
	public void setAvailabiltyOfInHouseTrainersInFoodSafety(String availabiltyOfInHouseTrainersInFoodSafety) {
		AvailabiltyOfInHouseTrainersInFoodSafety = availabiltyOfInHouseTrainersInFoodSafety;
	}
/*	public String getNoOfTrainingSessionWishToConductInAMonth() {
		return NoOfTrainingSessionWishToConductInAMonth;
	}
	public void setNoOfTrainingSessionWishToConductInAMonth(String noOfTrainingSessionWishToConductInAMonth) {
		NoOfTrainingSessionWishToConductInAMonth = noOfTrainingSessionWishToConductInAMonth;
	}*/
	
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
