package com.ir.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.trainingPartner.TrainingPartnerSearch;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.Utility;
import com.ir.service.TrainingPartnerService;

@Service
public class TrainingPartnerServiceImpl implements TrainingPartnerService  {

	@Autowired
	@Qualifier("trainingPartnerDAO")
	TrainingPartnerDao trainingPartnerDAO; 

	@Override
	@Transactional
	public List<PersonalInformationTrainingPartner> trainingCenterList() {
		List<PersonalInformationTrainingPartner> trainingCenterList = trainingPartnerDAO.trainingCenterList();
		return trainingCenterList;
	}

	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = trainingPartnerDAO.courseTypeList();
		return courseTypeList;
	}

	@Override
	@Transactional
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		String postVacancyTrainingPartner = trainingPartnerDAO.postVacancyTrainingPartner(postVacancyTrainingCenterForm);
		return postVacancyTrainingPartner;
	}

	@Override
	@Transactional
	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTraineeSave = trainingPartnerDAO.changePasswordTrainingPartnerSave(changePasswordForm , id);
		return changePasswordTraineeSave;
	}

	@Override
	@Transactional
	public List<CourseType> courseTypes() {
		System.out.println("TrainingPartnerServiceImpl");
		List<CourseType> courseTypeList = trainingPartnerDAO.courseTypes();
		return courseTypeList;
	}
	@Override
	@Transactional
	public List<IntStringBean> getTrainerList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<IntStringBean> trainerList = trainingPartnerDAO.getTrainerList();
		return trainerList;
	}
	@Override
	@Transactional
	public List<IntStringBean> getTraineeList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<IntStringBean> traineeList = trainingPartnerDAO.getTraineeList();
		return traineeList;
	}
	@Override
	@Transactional
	public List<IntStringBean> getTrainingCenterList(Integer userId,Integer profileId) {
		System.out.println("TrainingPartnerServiceImpl");
		List<IntStringBean> trainingCenterList = trainingPartnerDAO.getTrainingCenterList(userId,profileId);
		return trainingCenterList;
	}
	//getTrainingCenter
	@Override
	@Transactional
	public int getTrainingCenter(Integer userId,Integer profileId) {
		System.out.println("TrainingPartnerServiceImpl");
		int trainingCenter = trainingPartnerDAO.getTrainingCenter(userId,profileId);
		return trainingCenter;
	}
	@Override
	@Transactional
	public List<IntStringBean> getAssessorList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<IntStringBean> assessorList = trainingPartnerDAO.getAssessorList();
		return assessorList;
	}
	@Override
	@Transactional
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		return trainingPartnerDAO.editApplicationStatus(postVacancyTrainingCenterBean);
	}
	@Override
	@Transactional
	public List<PostVacancyTrainingCenterBean> getTrainingCalenderList(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		return trainingPartnerDAO.getTrainingCalenderList(postVacancyTrainingCenterBean);
	}
	
	@Override
	@Transactional
	public List<StringStringBean> getStatusList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<StringStringBean> statusList = trainingPartnerDAO.getStatusList();
		return statusList;
	}
	@Override
	@Transactional
	public List<StringStringBean> getModeOfTrainingList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<StringStringBean> modeoftraininglist = trainingPartnerDAO.getModeOfTrainingList();
		return modeoftraininglist;
	}
	@Override
	@Transactional
	public List<CourseName> getCourseNameList(){
		return  trainingPartnerDAO.getCourseNameList();
	}

	@Override
	@Transactional
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList(Integer userId) {
		return  trainingPartnerDAO.getPostVacancyTrainingList(userId);
	}

	@Override
	@Transactional
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,Integer profileID, Integer userId) {
		return  trainingPartnerDAO.saveVacancy(postVacancyTrainingCenterBean,profileID,userId);
	}

	@Override
	@Transactional
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		return trainingPartnerDAO.getAppliedCount(postVacancyTrainingCenterBean);
	}

	@Override
	@Transactional
	public void updateApplicationStatusForEnrolledVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		trainingPartnerDAO.updateApplicationStatusForEnrolledVacancy(postVacancyTrainingCenterBean);
		
	}

	@Override
	@Transactional
	public PostVacancyTrainingCenterBean getApplicationStatusBean(String loginId,int coursename, int cousertype) {
		return trainingPartnerDAO.getApplicationStatusBean(loginId,coursename, cousertype);
	}

	@Override
	@Transactional
	public void updateUpcomingTrainingsStatus(int id) {
		trainingPartnerDAO.updateUpcomingTrainingsStatus(id);
	}
	@Override
	@Transactional
	public List<TrainingPartnerSearch> getTrainingPartnerDetails(int trainingPartnerId){
		return trainingPartnerDAO.getTrainingPartnerDetails(trainingPartnerId);
	}
	@Override
	@Transactional
	public String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm) {
		String trainingCalendar = trainingPartnerDAO.trainingCalendarForm(trainingCalendarForm);
		return trainingCalendar;
	}
	
	@Override
	@Transactional
	public void setTrainingCalanderDeatils(TrainingCalendarForm trainingCalendarForm , String loginId) {
		trainingPartnerDAO.setTrainingCalanderDeatils(trainingCalendarForm , loginId);
	}
	
	
	@Override
	@Transactional
	public void cancelTrainingCalendar(int id) {
		trainingPartnerDAO.cancelTrainingCalndar(id);
	}
	
	

	@Override
	@Transactional
	public List<IntStringBean> loadAssessmentAgency() {
		List<IntStringBean> loadAssessmentAgency = trainingPartnerDAO.loadAssessmentAgency();
		return loadAssessmentAgency;
	}
	
	//getBatchCodeList
	
	@Override
	@Transactional
	public List<String> getBatchCodeList(int courseCode) {
		List<String> loadBatchCode = trainingPartnerDAO.getBatchCodeList(courseCode);
		return loadBatchCode;
	}
	//getCertificateIdList
	
	@Override
	@Transactional
	public List<String> getCertificateIdList(String batchcode , String loginId) {
		List<String> loadCertificate = trainingPartnerDAO.getCertificateIdList(batchcode , loginId);
		return loadCertificate;
	}
	
	//getTrainingPartnerList
	
	
	@Override
	@Transactional
	public List getTrainingPartnerList(String searchData) {
		List loadTrainingList = trainingPartnerDAO.getTrainingPartnerList(searchData);
		return loadTrainingList;
	}
	
	//traineeCenterViewTraineeList
	
	@Override
	@Transactional
	public List traineeCenterViewTraineeList(String searchData) {
		List loadTrainingList = trainingPartnerDAO.traineeCenterViewTraineeList(searchData);
		return loadTrainingList;
	}
	
	//searchMarkAttendance
	
	
	@Override
	@Transactional
	public List searchMarkAttendance(String searchData) {
		List loadTrainingList = trainingPartnerDAO.searchMarkAttendance(searchData);
		return loadTrainingList;
	}
	
	
	//traineeCenterPaymentConfirmation
	
	
	@Override
	@Transactional
	public List traineeCenterPaymentConfirmation(String searchData) {
		List loadTrainingList = trainingPartnerDAO.traineeCenterPaymentConfirmation(searchData);
		return loadTrainingList;
	}
	
	//trainingpartnermanagetrainer
	
	
	@Override
	@Transactional
	public List trainingpartnermanagetrainer(String searchData) {
		List loadTrainingList = trainingPartnerDAO.trainingpartnermanagetrainer(searchData);
		return loadTrainingList;
	}
	
	//searchVacancy
	

	@Override
	@Transactional
	public List searchVacancy(String searchData) {
		List loadTrainingList = trainingPartnerDAO.searchVacancy(searchData);
		return loadTrainingList;
	}
	
	//updateAttendanceStatus
	

	@Override
	@Transactional
	public String updateAttendanceStatus(String searchData) {
		String loadTrainingList = trainingPartnerDAO.updateAttendanceStatus(searchData);
		return loadTrainingList;
	}
	
	//SearchUpcomingTraining
	
	
	@Override
	@Transactional
	public List SearchUpcomingTraining(String data) {
		List loadTrainingList = trainingPartnerDAO.SearchUpcomingTraining(data);
		return loadTrainingList;
	}
	
	//searchTrainingCenterList
	
	
	@Override
	@Transactional
	public List searchTrainingCenterList(String data) {
		List loadTrainingList = trainingPartnerDAO.searchTrainingCenterList(data);
		return loadTrainingList;
	}
	
	
	//onLoadTrainingPartnerCenterId
	
	@Override
	@Transactional
	public List onLoadTrainingPartnerCenterId(String data) {
		List loadTrainingList = trainingPartnerDAO.onLoadTrainingPartnerCenterId(data);
		return loadTrainingList;
	}
	
//	/markTraineeAttendance
	@Override
	@Transactional
	public String markTraineeAttendance(String searchData) {
		String loadTrainingList = trainingPartnerDAO.markTraineeAttendance(searchData);
		return loadTrainingList;
	}
	
	//updateTrainingCalendar
	
	@Override
	@Transactional
	public String updateTrainingCalendar(String searchData) {
		String loadTrainingList = trainingPartnerDAO.updateTrainingCalendar(searchData);
		return loadTrainingList;
	}
	
	//certificateForTraineeList
	
	@Override
	@Transactional
	public List certificateForTraineeList(String searchData) {
		List loadTrainingList = trainingPartnerDAO.certificateForTraineeList(searchData);
		return loadTrainingList;
	}
	
	
//	/searchDataTP
	
	@Override
	@Transactional
	public List searchDataTP(String searchData) {
		List loadTrainingList = trainingPartnerDAO.searchDataTP(searchData);
		return loadTrainingList;
	}
	
	//editMTP
	
	@Override
	@Transactional
	public List editMTP(String searchData) {
		List loadTrainingList = trainingPartnerDAO.editMTP(searchData);
		return loadTrainingList;
	}
	//updateMTP
	
	@Override
	@Transactional
	public String updateMTP(String searchData) {
		String loadTrainingList = trainingPartnerDAO.updateMTP(searchData);
		return loadTrainingList;
	}
}
