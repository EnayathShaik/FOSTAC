package com.ir.dao;

import java.util.List;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.AdmitCardForm;
import com.ir.model.CertificateInfo;
import com.ir.model.CheckAadhar;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.Utility;

public interface TraineeDAO {
	
	public List<CourseName> courseNameList();
	public List<String> courseTypes();
	List<CourseType> courseTypeList();
	public List<CourseName> courseNameListByType(int courseType);
	public CourseName getCourseName(int profileId);
	public CourseName getCourseDetails(int loginId);
	public CourseTrainee getCourseTrainingByCourseTypeID(int typeId);
	public List<CourseTrainee> getCourseTrainingByCourseTypeIDList(int typeId);
	public String isTraineeEligible(int userID);
	public List<ManageTrainingPartner> trainingPartnerList();
	public List<FeedbackMaster> getFeedMasterList(int profileId);

	public List<State> trainingCenterStateList();

	public String updateTrainee(RegistrationFormTrainee registrationFormTrainee , Integer ss);

	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);

	public String basicSave(CourseEnrolledUserForm courseEnrolledUserForm  , int loginid, int tableID, Integer profileID);

	Title getTitle(int id);

	District getDistrict(int id);

	City getCity(int id);

	State getState(int id);

	KindOfBusiness getKid(int id);

	public String contactTraineeSave(ContactTrainee contactTrainee , String id);

//	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);
	// Rishi
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid, int tableID, Integer profileID);

	public long specialTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid, int tableID, Integer profileId);

	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id);
	public AdmitCardForm generateAdmitCard(int loginId,int profileId);
	public List<FeedbackForm> getFeedbackDetails(Utility utility);
	public int getCurrentCourseId(int loginId);
	
	public AdmitCardForm generateTrainerAdmitCard(int loginId,int profileId);
	
	public String getDefaultMailID(int loginId,int profileId);
	public int getTableIdForEnrolmentID(int loginId,int profileId);
	public PersonalInformationTrainee fullDetail(int loginId);
	public Boolean updateSteps(int tableID, int profileID, int steps);
	public String isCourseOnline(int userID);
	public Boolean closeCourse(int tableID, int profileID, String status);
	public CertificateInfo getCertificateID(int userID, int profileID, String certificateID);
	public String isAadharExist(CheckAadhar checkAadhar);
	public List<State> stateList();
	
	public List getCourseDetails(String data);
	
	public List getAttendanceDeatilsByID(String id);
	
	public String savePaymentStatus(String data);
}
