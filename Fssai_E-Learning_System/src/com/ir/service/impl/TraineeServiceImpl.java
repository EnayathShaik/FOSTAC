package com.ir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.TraineeDAO;
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
import com.ir.model.State;
import com.ir.model.Utility;
import com.ir.service.TraineeService;

public class TraineeServiceImpl implements TraineeService {

	@Autowired
	@Qualifier("traineeDAO")
	public TraineeDAO traineeDAO;
	
	@Override
	public List<CourseName> courseNameList() {
		List<CourseName> courseNameList = traineeDAO.courseNameList();
		return courseNameList;
	}
	@Override
	public List<CourseName> courseNameListByType(int courseType) {
		List<CourseName> courseNameList = traineeDAO.courseNameListByType(courseType);
		return courseNameList;
	}
	@Override
		public CourseTrainee getCourseTrainingByCourseTypeID(int typeId) {
			CourseTrainee courseTrainee = traineeDAO.getCourseTrainingByCourseTypeID(typeId);
			return courseTrainee;
		}
	@Override
	public CourseName getCourseName(int loginId) {
		CourseName courseName = traineeDAO.getCourseName(loginId);
		return courseName;
	}
	@Override
	public CourseName getCourseDetails(int loginId) {
		CourseName courseName = traineeDAO.getCourseDetails(loginId);
		return courseName;
	}
	@Override
	public List<FeedbackMaster> getFeedMasterList(int profileId) {
		List<FeedbackMaster> feedbackMasters = traineeDAO.getFeedMasterList(profileId);
		return feedbackMasters;
	}

	@Override
	public List<ManageTrainingPartner> trainingPartnerList() {
		List<ManageTrainingPartner> trainingPartnerList = traineeDAO.trainingPartnerList();
		return trainingPartnerList;
	}

	@Override
	public List<State> trainingCenterStateList() {
		List<State> trainingCenterStateList = traineeDAO.trainingCenterStateList();
		return trainingCenterStateList;
	}

	@Override
	public String updateTrainee(RegistrationFormTrainee registrationFormTrainee , Integer ss) {
		String updateTrainee= traineeDAO.updateTrainee(registrationFormTrainee , ss);
		return updateTrainee;
	}

	@Override
	public long basicSave(CourseEnrolledUserForm courseEnrolledUserForm ,int loginid, int tableID,Integer profileID) {
		long basicEnroll= traineeDAO.basicSave(courseEnrolledUserForm , loginid , tableID, profileID);
		return basicEnroll;
	}
	@Override
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTraineeSave= traineeDAO.changePasswordTraineeSave(changePasswordForm , id);
		return changePasswordTraineeSave;
	}
	@Override
	public String contactTraineeSave(ContactTrainee contactTrainee , String id) {
		String contactTraineeSave = traineeDAO.contactTraineeSave(contactTrainee , id);
		return contactTraineeSave;
	}
@Override
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid,
			int personalinformationtraineeid) {
		long advanceEnroll= traineeDAO.advanceTraineeSave(courseEnrolledUserForm , loginid , personalinformationtraineeid);
		return advanceEnroll;
	}

	@Override
	public long specialTrainee(CourseEnrolledUserForm courseEnrolledUserForm, int loginid,
			int personalinformationtraineeid) {
		long specialEnroll= traineeDAO.specialTraineeSave(courseEnrolledUserForm , loginid , personalinformationtraineeid);
		return specialEnroll;
	}
	

	@Override
	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordAssesorSave= traineeDAO.changePasswordAssesorSave(changePasswordForm , id);
		return changePasswordAssesorSave;
	}
	public AdmitCardForm generateAdmitCard(int loginId,int profileId){
		AdmitCardForm admitCardObj = traineeDAO.generateAdmitCard(loginId,profileId);
		return admitCardObj;
	}
	@Override
	public List<FeedbackForm> getFeedbackDetails(Utility utility) {
		return traineeDAO.getFeedbackDetails(utility);
	}
	@Override
	public int getCurrentCourseId(int loginId){
		return traineeDAO.getCurrentCourseId(loginId);
	}
	@Override
	public AdmitCardForm generateTrainerAdmitCard(int loginId,int profileId){
		AdmitCardForm admitCardObj = traineeDAO.generateTrainerAdmitCard(loginId,profileId);
		return admitCardObj;
	}
	@Override
	public String getDefaultMailID(int loginId, int profileId) {
		// TODO Auto-generated method stub
		return traineeDAO.getDefaultMailID(loginId, profileId);
	}
	@Override
	public PersonalInformationTrainee FullDetail(int loginId) {
		PersonalInformationTrainee personalInformationTrainee = traineeDAO.fullDetail(loginId);
		return personalInformationTrainee;
	}
	@Override
	public int getTableIdForEnrolmentID(int loginId, int profileId) {
		// TODO Auto-generated method stub
		return traineeDAO.getTableIdForEnrolmentID(loginId, profileId);
	}
	@Override
	public Boolean updateSteps(int tableID, int profileID, int steps) {
		// TODO Auto-generated method stub
		return traineeDAO.updateSteps(tableID, profileID,steps);
	}
	@Override
	public String isCourseOnline(int userID) {
		// TODO Auto-generated method stub
		return traineeDAO.isCourseOnline(userID);
	}
}
