package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.bean.common.IntStringBean;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionForm;
import com.ir.form.AssessorUserManagementForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.CityForm;
import com.ir.form.ContactTrainee;
import com.ir.form.DistrictForm;
import com.ir.form.ManageAssessmentAgencyForm;
import com.ir.form.ManageCourse;
import com.ir.form.ManageCourseContentForm;
import com.ir.form.ManageTrainingPartnerForm;
import com.ir.form.RegionForm;
import com.ir.form.StateForm;
import com.ir.form.TraineeUserManagementForm;
import com.ir.form.TrainerUserManagementForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.TrainingCenterUserManagementForm;
import com.ir.model.AdminUserManagement;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.TrainingPartner;
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainee.TraineeAssessmentEvaluation;
import com.ir.model.trainer.TrainerAssessmentEvaluation;

public interface AdminService {

	String stateMasterSave(StateForm stateForm);
	//public stateSave()
	@Transactional
	List<State> stateList();
	
	@Transactional
	String districtMasterSave(DistrictForm districtForm);
	
	@Transactional
	String cityMasterSave(CityForm cityForm);
	
	@Transactional
	String regionMasterSave(RegionForm regionForm);
	
	@Transactional
	List<CourseName> courseNameList();
	
	@Transactional
	String manageCourse(ManageCourse manageCourse);
	
	@Transactional
	List<CourseType> courseTypeList();
	
	@Transactional
	String manageTrainingPartnerSave(ManageTrainingPartnerForm manageTrainingPartnerForm);
	
	@Transactional
	String manageAssessmentAgencySave(ManageAssessmentAgencyForm manageAssessmentAgencyForm);
	
	@Transactional
	List<PersonalInformationTrainee> traineeUserManagementSearch(TraineeUserManagementForm traineeUserManagementForm);
	
	@Transactional
	List<PersonalInformationTrainer> trainerUserManagementSearch(TrainerUserManagementForm trainerUserManagementForm);
	
	@Transactional
	List<PersonalInformationTrainingPartner> trainingCenterUserManagementSearch(TrainingCenterUserManagementForm trainingCenterUserManagementForm,Integer profileId,Integer userId);
	
	@Transactional
	List<PersonalInformationAssessor> assessorUserManagementSearch(AssessorUserManagementForm assessorUserManagementForm,Integer profileid,Integer userID);
	
	@Transactional
	List<AdminUserManagement> adminUserManagementSearch();
	
	@Transactional
	String adminUserManagementSave(AdminUserManagementForm adminUserManagementForm);
	
	@Transactional
	String manageCourseContentSearch(ManageCourseContentForm manageCourseContentForm);
	
	@Transactional
	List<ManageTrainingPartner> trainingPartnerList();
	
	@Transactional
	List<PersonalInformationTrainer> trainingNameList();
	
	@Transactional
	String assessorUserManagementSave(AssessorUserManagementForm assessorUserManagementForm);
	
	@Transactional
	List<District> districtList();
	
	@Transactional
	String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm);
	
	@Transactional
	String manageAssessmentQuestionsSave(AssessmentQuestionForm assessmentQuestionForm);
//	boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	boolean changePasswordTPSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	boolean changePasswordadminSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	String contactTraningPTSave(ContactTrainee contactTrainee, String id);
	
	@Transactional
	String saveFeedbackMaster(FeedbackMaster feedbackMaster);
	
	@Transactional
	List<IntStringBean> getTrainingCentersByCourse(int courseNameId);
	
	@Transactional
	List<TrainerAssessmentSearchForm> searchTrainerForAssessmentValidation(int courseNameId, int trainingPartnerId);
	
	@Transactional
	TrainerAssessmentSearchForm evaluateTrainerAssessment(TrainerAssessmentSearchForm trainerAssessmentForm);
	
	@Transactional
	int saveTrainerAssessment(TrainerAssessmentEvaluation trainerAssessmentEvaluation);

}
