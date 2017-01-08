package com.ir.service;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.AdmitCardForm;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.TrainingPartner;
import com.ir.model.Utility;

public interface TraineeService {
	public List<CourseName> courseNameList();
	public List<CourseName> courseNameListByType(int courseType);
	public CourseTrainee getCourseTrainingByCourseTypeID(int typeId);
	public List<ManageTrainingPartner> trainingPartnerList();
	public List<State> trainingCenterStateList();
	public String updateTrainee(RegistrationFormTrainee registrationFormTrainee , Integer ss);
	public String contactTraineeSave(ContactTrainee contactTrainee , String id);
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);
	public long basicSave(CourseEnrolledUserForm courseEnrolledUserForm , int loginid, int tableID,Integer profileId);
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid,
			int personalinformationtraineeid);
	public long specialTrainee(CourseEnrolledUserForm courseEnrolledUserForm, int loginid,
			int personalinformationtraineeid);
	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id);
	public CourseName getCourseDetails(int loginId);
	public CourseName getCourseName(int profileId);
	public List<FeedbackMaster> getFeedMasterList(int profileId);
	public AdmitCardForm generateAdmitCard(int loginId,int profileId);
	public List<FeedbackForm> getFeedbackDetails(Utility utility);
	public int getCurrentCourseId(int loginId);
	public AdmitCardForm generateTrainerAdmitCard(int loginId,int profileId);
	public String getDefaultMailID(int loginId,int profileId);
	public int getTableIdForEnrolmentID(int loginId,int profileId);
	public PersonalInformationTrainee FullDetail(int loginId);
	public Boolean updateSteps(int tableID, int profileID, int steps);
	public String isCourseOnline(int userID);
}
