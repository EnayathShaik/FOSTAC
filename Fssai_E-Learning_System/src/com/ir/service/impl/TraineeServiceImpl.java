package com.ir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.TraineeDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.AdmitCardForm;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.FeedbackMaster;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
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
	public CourseTrainee getCourseTrainingByCourseTypeID(int typeId) {
		CourseTrainee courseTrainee = traineeDAO.getCourseTrainingByCourseTypeID(typeId);
		return courseTrainee;
	}
@Override
public CourseName getCourseName(int profileId) {
	CourseName courseName = traineeDAO.getCourseName(profileId);
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
	public long basicSave(CourseEnrolledUserForm courseEnrolledUserForm ,String loginid, int personalinformationtraineeid) {
		long basicEnroll= traineeDAO.basicSave(courseEnrolledUserForm , loginid , personalinformationtraineeid);
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
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, String loginid,
			int personalinformationtraineeid) {
		long advanceEnroll= traineeDAO.advanceTraineeSave(courseEnrolledUserForm , loginid , personalinformationtraineeid);
		return advanceEnroll;
	}

	@Override
	public long specialTrainee(CourseEnrolledUserForm courseEnrolledUserForm, String loginid,
			int personalinformationtraineeid) {
		long specialEnroll= traineeDAO.specialTraineeSave(courseEnrolledUserForm , loginid , personalinformationtraineeid);
		return specialEnroll;
	}
	

	@Override
	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordAssesorSave= traineeDAO.changePasswordAssesorSave(changePasswordForm , id);
		return changePasswordAssesorSave;
	}
	public AdmitCardForm generateAdmitCard(int loginId){
		AdmitCardForm admitCardObj = traineeDAO.generateAdmitCard(loginId);
		return admitCardObj;
	}
}
