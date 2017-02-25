package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.AdmitCardForm;
import com.ir.model.CertificateInfo;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.TrainingPartner;
import com.ir.model.Utility;


public interface TraineeService {
	@Transactional
	public List<CourseName> courseNameList();
	
	@Transactional
	public List<String> courseTypes();
	
	@Transactional
	List<CourseType> courseTypeList();
	
	@Transactional
	public List<CourseName> courseNameListByType(int courseType);
	
	@Transactional
	public CourseTrainee getCourseTrainingByCourseTypeID(int typeId);
	
	@Transactional
	public String isTraineeEligible(int userID,String isOnline);
	
	@Transactional
	public List<ManageTrainingPartner> trainingPartnerList();
	
	@Transactional
	public List<State> trainingCenterStateList();
	
	@Transactional
	public String updateTrainee(RegistrationFormTrainee registrationFormTrainee , Integer ss);
	
	@Transactional
	public String contactTraineeSave(ContactTrainee contactTrainee , String id);
	
	@Transactional
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	public String basicSave(CourseEnrolledUserForm courseEnrolledUserForm , int loginid, int tableID,Integer profileId);
	
	@Transactional
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid, int tableID,Integer profileId);
	
	@Transactional
	public long specialTrainee(CourseEnrolledUserForm courseEnrolledUserForm, int loginid, int tableID, Integer profileId);
	
	@Transactional
	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	public CourseName getCourseDetails(int loginId);
	
	@Transactional
	public CourseName getCourseName(int profileId);
	
	@Transactional
	public List<FeedbackMaster> getFeedMasterList(int profileId);
	
	@Transactional
	public AdmitCardForm generateAdmitCard(int loginId,int profileId);
	
	@Transactional
	public List<FeedbackForm> getFeedbackDetails(Utility utility);
	
	@Transactional
	public int getCurrentCourseId(int loginId);
	
	@Transactional
	public AdmitCardForm generateTrainerAdmitCard(int loginId,int profileId);
	
	@Transactional
	public String getDefaultMailID(int loginId,int profileId);
	
	@Transactional
	public int getTableIdForEnrolmentID(int loginId,int profileId);
	
	@Transactional
	public PersonalInformationTrainee FullDetail(int loginId);
	
	@Transactional
	public Boolean updateSteps(int tableID, int profileID, int steps);
	
	@Transactional
	public Boolean closeCourse(int userId, int profileID, String status);
	
	@Transactional
	public String isCourseOnline(int userID);
	
	@Transactional
	public CertificateInfo getCertificateID(int userID, int profileID);


}
