package com.ir.dao;

import java.util.List;

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
import com.ir.model.City;
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

public interface AdminDAO {
	
	public String stateMasterSave(StateForm stateForm);

	public List<State> stateList();

	public String districtMasterSave(DistrictForm districtForm);

	public String cityMasterSave(CityForm cityForm);

	public String regionMasterSave(RegionForm regionForm);

	public List<CourseName> courseNameList();

	public String manageCourse(ManageCourse manageCourse);

	public List<CourseType> courseTypeList();

	public String manageTrainingPartnerSave(ManageTrainingPartnerForm manageTrainingPartnerForm);

	public String manageAssessmentAgencySave(ManageAssessmentAgencyForm manageAssessmentAgencyForm);

	public List<PersonalInformationTrainee> traineeUserManagementSearch(TraineeUserManagementForm traineeUserManagementForm);
	public List<PersonalInformationTrainer> trainerUserManagementSearch(TrainerUserManagementForm trainerUserManagementForm);
	public List<PersonalInformationAssessor> assessorUserManagementSearch(AssessorUserManagementForm assessorUserManagementForm);
	public List<PersonalInformationTrainingPartner> trainingCenterUserManagementSearch(TrainingCenterUserManagementForm trainingCenterUserManagementForm);
	public List<AdminUserManagement> adminUserManagementSearch();

	public String adminUserManagementSave(AdminUserManagementForm adminUserManagementForm);

	public String manageCourseContentSearch(ManageCourseContentForm manageCourseContentForm);

	public List<ManageTrainingPartner> trainingPartnerList();

	public List<PersonalInformationTrainer> trainingNameList();

	public String assessorUserManagementSave(AssessorUserManagementForm assessorUserManagementForm);

	public List<District> districtList();

	public String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm);

	State getState(int id);

	public String manageAssessmentQuestionsSave(AssessmentQuestionForm assessmentQuestionForm);

	CourseType getCourseType(int id);

	CourseName getCourseName(int id);

	District getDistrict(int id);

	City getCity(int id);
// Rishi
	public boolean trainingadminForm(ChangePasswordForm changePasswordForm, String id);

	public boolean trainingPartnerPass(ChangePasswordForm changePasswordForm, String id);

	public String contactTrainigPartnerSave(ContactTrainee contactTrainee, String id);
	public String saveFeedbackMaster(FeedbackMaster feedbackMaster);
	

	//public boolean trainingadminForm(ChangePasswordForm changePasswordForm, String id);

		// Rishi

}
