package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AdminDAO;
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
import com.ir.form.TrainingCenterReport;
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
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainer.TrainerAssessmentEvaluation;
import com.ir.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	@Qualifier("adminDAO")
	AdminDAO adminDAO; 

	@Override
	@Transactional
	public String stateMasterSave(StateForm stateForm) {
		// TODO Auto-generated method stub
		String stateMasterSave = adminDAO.stateMasterSave(stateForm);
		return stateMasterSave;
	}

	@Override
	@Transactional
	public List<State> stateList() {
		// TODO Auto-generated method stub
		List<State> stateList = adminDAO.stateList();
		return stateList;
	}

	@Override
	@Transactional
	public String districtMasterSave(DistrictForm districtForm) {
		// TODO Auto-generated method stub
		String districtMasterSave = adminDAO.districtMasterSave(districtForm);
		return districtMasterSave;
	}

	@Override
	@Transactional
	public String cityMasterSave(CityForm cityForm) {
		String cityMasterSave = adminDAO.cityMasterSave(cityForm);
		return cityMasterSave;
	}

	@Override
	@Transactional
	public String regionMasterSave(RegionForm regionForm) {
		String regionMasterSave = adminDAO.regionMasterSave(regionForm);
		return regionMasterSave;
	}

	@Override
	@Transactional
	public List<CourseName> courseNameList() {
		List<CourseName> courseNameList = adminDAO.courseNameList();
		return courseNameList;
	}

	@Override
	@Transactional
	public String manageCourse(ManageCourse manageCourse) {
		String manageCourse1 = adminDAO.manageCourse(manageCourse);
		return manageCourse1;
	}

	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		System.out.println("AdminDao");
		List<CourseType> courseTypeList = adminDAO.courseTypeList();
		return courseTypeList;
	}

	@Override
	@Transactional
	public String manageTrainingPartnerSave(ManageTrainingPartnerForm manageTrainingPartnerForm) {
		// TODO Auto-generated method stub
		String manageTrainingPartnerSave = adminDAO.manageTrainingPartnerSave(manageTrainingPartnerForm);
		return manageTrainingPartnerSave;
	}

	@Override
	@Transactional
	public String manageAssessmentAgencySave(ManageAssessmentAgencyForm manageAssessmentAgencyForm) {
		String manageAssessmentAgencySave = adminDAO.manageAssessmentAgencySave(manageAssessmentAgencyForm);
		return manageAssessmentAgencySave;
	}

	@Override
	@Transactional
	public List<PersonalInformationTrainee> traineeUserManagementSearch(TraineeUserManagementForm traineeUserManagementForm) {
		List<PersonalInformationTrainee> traineeUserManagementSearch = adminDAO.traineeUserManagementSearch(traineeUserManagementForm);
		return traineeUserManagementSearch;
	}
	@Override
	@Transactional
	public List<PersonalInformationTrainer> trainerUserManagementSearch(TrainerUserManagementForm trainerUserManagementForm) {
		List<PersonalInformationTrainer> trainerUserManagementSearch = adminDAO.trainerUserManagementSearch(trainerUserManagementForm);
		return trainerUserManagementSearch;
	}
	
	@Override
	@Transactional
	public List<PersonalInformationAssessor> assessorUserManagementSearch(AssessorUserManagementForm assessorUserManagementForm,Integer profileid,Integer userID) {
		List<PersonalInformationAssessor> assessorUserManagementSearch1 = adminDAO.assessorUserManagementSearch(assessorUserManagementForm,profileid,userID);
		return assessorUserManagementSearch1;
	}
	
	@Override
	@Transactional
	public List<PersonalInformationTrainingPartner> trainingCenterUserManagementSearch(TrainingCenterUserManagementForm trainingCenterUserManagementForm,Integer profileid,Integer userID) {
		List<PersonalInformationTrainingPartner> trainingCenterUserManagementSearch = adminDAO.trainingCenterUserManagementSearch(trainingCenterUserManagementForm,profileid,userID);
		return trainingCenterUserManagementSearch;
	}
	@Override
	@Transactional
	public List<AdminUserManagement> adminUserManagementSearch() {
		List<AdminUserManagement> adminUserManagementSearch = adminDAO.adminUserManagementSearch();
		return adminUserManagementSearch;
	}

	@Override
	@Transactional
	public String adminUserManagementSave(AdminUserManagementForm adminUserManagementForm) {
		String adminUserManagementSave = adminDAO.adminUserManagementSave(adminUserManagementForm);
		return adminUserManagementSave;
	}

	@Override
	@Transactional
	public String manageCourseContentSearch(ManageCourseContentForm manageCourseContentForm) {
		String manageCourseContentSearch = adminDAO.manageCourseContentSearch(manageCourseContentForm);
		return manageCourseContentSearch;
	}

	@Override
	@Transactional
	public List<ManageTrainingPartner> trainingPartnerList() {
		List<ManageTrainingPartner> trainingPartnerList = adminDAO.trainingPartnerList();
		return trainingPartnerList;
	}

	@Override
	@Transactional
	public List<PersonalInformationTrainer> trainingNameList() {
		List<PersonalInformationTrainer> trainingNameList = adminDAO.trainingNameList();
		return trainingNameList;
	}

	@Override
	@Transactional
	public String assessorUserManagementSave(AssessorUserManagementForm assessorUserManagementForm) {
		String assessorUserManagementSave = adminDAO.assessorUserManagementSave(assessorUserManagementForm);
		return assessorUserManagementSave;
	}

	@Override
	@Transactional
	public List<District> districtList() {
		List<District> districtList = adminDAO.districtList();
		return districtList;
	}

	@Override
	@Transactional
	public String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm) {
		String trainingCalendar = adminDAO.trainingCalendarForm(trainingCalendarForm);
		return trainingCalendar;
	}

	@Override
	@Transactional
	public String manageAssessmentQuestionsSave(AssessmentQuestionForm assessmentQuestionForm) {
		String manageAssessmentQuestionsSave = adminDAO.manageAssessmentQuestionsSave(assessmentQuestionForm);
		return manageAssessmentQuestionsSave;
	}
		// Rishi
	@Override
	@Transactional
	public boolean changePasswordadminSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordadmin = adminDAO.trainingadminForm(changePasswordForm,id);
		return changePasswordadmin;
	}

	@Override
	@Transactional
	public boolean changePasswordTPSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordadmin = adminDAO.trainingPartnerPass(changePasswordForm,id);
		return changePasswordadmin;
	}

	@Override
	@Transactional
	public String contactTraningPTSave(ContactTrainee contactTrainee, String id) {
		String contactTrainingPTSave = adminDAO.contactTrainigPartnerSave(contactTrainee , id);
		return contactTrainingPTSave;
	}

	@Override
	@Transactional
	public String saveFeedbackMaster(FeedbackMaster feedbackMaster) {
		String saveFeedbackMaster = adminDAO.saveFeedbackMaster(feedbackMaster);
		return saveFeedbackMaster;
	}
	
	@Override
	@Transactional
	public List<IntStringBean> getTrainingCentersByCourse(int courseNameId){
		List <IntStringBean> listTrainingCenters = adminDAO.getTrainingCentersByCourse(courseNameId);
		return listTrainingCenters;
	}
	@Override
	@Transactional
	public List<TrainerAssessmentSearchForm> searchTrainerForAssessmentValidation(int courseNameId, int trainingPartnerId){
		List<TrainerAssessmentSearchForm> list = adminDAO.searchTrainerForAssessmentValidation(courseNameId, trainingPartnerId);
		return list;
	}
	@Override
	@Transactional
	public TrainerAssessmentSearchForm evaluateTrainerAssessment(TrainerAssessmentSearchForm trainerAssessmentForm){
		
		int eligibility = adminDAO.getElegibilityForAssessment(trainerAssessmentForm.getCourseNameId());
		int rating = trainerAssessmentForm.getRating();
		if(eligibility > -1){
			if(rating >= eligibility){
				trainerAssessmentForm.setResult("Pass");
			}else{
				trainerAssessmentForm.setResult("Fail");
			}
		}else{
			trainerAssessmentForm.setResult("Eligibility yet to declare");
		}
		return trainerAssessmentForm;
		
	}
	
	@Override
	@Transactional
	public int saveTrainerAssessment(TrainerAssessmentEvaluation trainerAssessmentEvaluation){
		int assessmentId = adminDAO.saveTrainerAssessment(trainerAssessmentEvaluation);
		return assessmentId;
	}
	//updateUser
	
	@Override
	public void updateUser( String userid , String tableName , String status){
		adminDAO.updateUser(userid ,tableName ,status);
		
	}
	
	//searchManageCourse
	
	
	@Override
	@Transactional
	public List searchManageCourse(String data){
		List courseData = adminDAO.searchManageCourse(data);
		return courseData;
	}
	
	//editManageCourseData
	
	
	@Override
	@Transactional
	public String editManageCourseData(String data){
		String courseData = adminDAO.editManageCourseData(data);
		return courseData;
	}
	
	//editState
	
	@Override
	@Transactional
	public String editState(String data){
		String courseData = adminDAO.editState(data);
		return courseData;
	}
	
	//CheckState
	@Override
	@Transactional
	public String CheckState(String data){
		String courseData = adminDAO.CheckState(data);
		return courseData;
	}
	
	//searchState
	
	@Override
	@Transactional
	public List searchState(String data){
		List<State> courseData = adminDAO.searchState(data);
		return courseData;
	}
	
	
	//onLoadDistrict
	
	@Override
	@Transactional
	public List onLoadDistrict(String data){
		List courseData = adminDAO.onLoadDistrict(data);
		return courseData;
	}
	
	
	//changeStatusDistrict
	
	@Override
	@Transactional
	public String changeStatusDistrict(String data){
		String courseData = adminDAO.changeStatusDistrict(data);
		return courseData;
	}
	
	//searchDistrict
	
	@Override
	@Transactional
	public List searchDistrict(String data){
		List courseData = adminDAO.searchDistrict(data);
		return courseData;
	}
	
	//editCityData
	
	@Override
	@Transactional
	public String editCityData(String data){
		String courseData = adminDAO.editCityData(data);
		return courseData;
	}
	
	//searchCity
	
	@Override
	@Transactional
	public List searchCity(String data){
		List courseData = adminDAO.searchCity(data);
		return courseData;
	}
	
	//onLoadRegion
	
	@Override
	@Transactional
	public List onLoadRegion(String data){
		List courseData = adminDAO.onLoadRegion(data);
		return courseData;
	}
	
	//editRegionData
	
	@Override
	@Transactional
	public String editRegionData(String data){
		String courseData = adminDAO.editRegionData(data);
		return courseData;
	}
	
	//traineeAssessmentCalender
	
	@Override
	@Transactional
	public List traineeAssessmentCalender(String data){
		List courseData = adminDAO.traineeAssessmentCalender(data);
		return courseData;
	}
	
	//getQuestions
	@Override
	@Transactional
	public List getQuestions(String data){
		List courseData = adminDAO.getQuestions(data);
		return courseData;
	}
	
	//searchFeedbackMaster

	@Override
	@Transactional
	public List searchFeedbackMaster(String data){
		List courseData = adminDAO.searchFeedbackMaster(data);
		return courseData;
	}
	
	//searchAssessmentAgencyList
	
	
	@Override
	@Transactional
	public List searchAssessmentAgencyList(String data){
		List courseData = adminDAO.searchAssessmentAgencyList(data);
		return courseData;
	}
	
//	/searchAssessorDetail
	
	@Override
	@Transactional
	public List searchAssessorDetail(String data){
		List courseData = adminDAO.searchAssessorDetail(data);
		return courseData;
	}
	
	//changeAssessor
	@Override
	@Transactional
	public String changeAssessor(String data){
		String courseData = adminDAO.changeAssessor(data);
		return courseData;
	}	
	@Override
	@Transactional
	public List<TrainingCenterReport> trainingCenterDetails(int trainingPartner){
		List<TrainingCenterReport> courseData = adminDAO.trainingCenterDetails(trainingPartner);
		return courseData;
	}	
}
