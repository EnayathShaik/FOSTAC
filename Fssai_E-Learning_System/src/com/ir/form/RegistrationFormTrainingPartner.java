package com.ir.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RegistrationFormTrainingPartner {
	
	
	//@NotNull @Size(min=1, max=20 , message="* Enter UserId")
	private String UserId;
	
	private String TPName;
	@NotNull
	private int Title;
	public String getTPName() {
		return TPName;
	}
	public void setTPName(String tPName) {
		TPName = tPName;
	}
	@NotNull @Size(min=1, max=50 , message="* Enter Training Centre Name")
	private String TrainingCentreName;
	@NotNull(message="* Enter Training Partner Name")
	private int TrainingPartnerName;
	@NotNull @Size(min=1, max=50 , message="* Enter First Name")
	private String FirstName;
	@Size(min= 0 , max=50)
	private String MiddleName;
	@NotNull @Size(min=1, max=20 , message="* Enter Last Name")
	private String LastName;
	@NotNull @Size(min=10, max=50 , message="* Invalid PAN Number")
	private String PAN;
	@NotNull @Size(min=1, max=100 , message="* Enter Training Center Address ")
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
	
	private String TrainingPartnerPermanentEmail;
	
	private String TrainingPartnerPermanentMobile;
	
	private String TrainingPartnerPermanentLandLine;
	
	
	
	public String getTrainingPartnerPermanentLandLine() {
		return TrainingPartnerPermanentLandLine;
	}
	public void setTrainingPartnerPermanentLandLine(
			String trainingPartnerPermanentLandLine) {
		TrainingPartnerPermanentLandLine = trainingPartnerPermanentLandLine;
	}
	@NotNull @Size(min=1, max=4 , message="* Enter Seating Capacity Per Session")
	private String SeatCapacityPerSession;
/*	@NotNull @Size(min=1, max=4 , message="* Enter Number Of In-House Trainer ")
	private String NoOfInHouseTrainers;*/
	@NotNull @Size(min=1, max=4 , message="* Enter Availabilty Of TV Projectors ")
	private String AvailabiltyOfTVProjector;
/*	@NotNull @Size(min=1, max=2 , message="* Enter Number Of Years In Business Of Training")
	private String NoOfYearsInBusinessOfTraining;*/
	@NotNull @Size(min=1, max=1 , message="* Enter Availabilty Of In-House Trainers In Food Safety")
	private String AvailabiltyOfInHouseTrainersInFoodSafety;
/*	@NotNull @Size(min=1, max=2 , message="* Enter Number Of Training Session Wish To Conduct In A Month")
	private String NoOfTrainingSessionWishToConductInAMonth;*/
	
	@NotNull @Size(min=1, max=1 , message="* Enter Facility of Electricity + Air-Conditioner ")
	private String FacilityOfElectricityAndAirCondition;
	
	@NotNull @Size(min=1, max=1 , message="* Facility of Drinking Water")
	private String FacilityOfDrinkingWater;
	
	@NotNull @Size(min=1, max=1 , message="* Enter Facility of Washroom ")
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
	private String BasicCourse;
	private String AdvanceCourse;
	private String SpecialCourse;
	
	private String BasicCourse1;
	private String AdvanceCourse1;
	private String SpecialCourse1;
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
	public String getBasicCourse1() {
		return BasicCourse1;
	}
	public void setBasicCourse1(String basicCourse1) {
		BasicCourse1 = basicCourse1;
	}
	public String getAdvanceCourse1() {
		return AdvanceCourse1;
	}
	public void setAdvanceCourse1(String advanceCourse1) {
		AdvanceCourse1 = advanceCourse1;
	}
	public String getSpecialCourse1() {
		return SpecialCourse1;
	}
	public void setSpecialCourse1(String specialCourse1) {
		SpecialCourse1 = specialCourse1;
	}
	public String getTrainingCentreName() {
		return TrainingCentreName;
	}
	public void setTrainingCentreName(String TrainingCentreName) {
		this.TrainingCentreName = TrainingCentreName;
	}
	
	
}
