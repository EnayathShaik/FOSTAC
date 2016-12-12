package com.ir.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
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
	public List<PersonalInformationTrainingPartner> trainingCenterList() {
		List<PersonalInformationTrainingPartner> trainingCenterList = trainingPartnerDAO.trainingCenterList();
		return trainingCenterList;
	}

	@Override
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = trainingPartnerDAO.courseTypeList();
		return courseTypeList;
	}

	@Override
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		String postVacancyTrainingPartner = trainingPartnerDAO.postVacancyTrainingPartner(postVacancyTrainingCenterForm);
		return postVacancyTrainingPartner;
	}

	@Override
	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTraineeSave = trainingPartnerDAO.changePasswordTrainingPartnerSave(changePasswordForm , id);
		return changePasswordTraineeSave;
	}

	@Override
	public List<CourseType> courseTypes() {
		System.out.println("TrainingPartnerServiceImpl");
		List<CourseType> courseTypeList = trainingPartnerDAO.courseTypes();
		return courseTypeList;
	}
	@Override
	public List<IntStringBean> getTrainerList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<IntStringBean> trainerList = trainingPartnerDAO.getTrainerList();
		return trainerList;
	}
	@Override
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		return trainingPartnerDAO.editApplicationStatus(postVacancyTrainingCenterBean);
	}
	@Override
	public List<PostVacancyTrainingCenterBean> getTrainingCalenderList(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		return trainingPartnerDAO.getTrainingCalenderList(postVacancyTrainingCenterBean);
	}
	
	@Override
	public List<StringStringBean> getStatusList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<StringStringBean> statusList = trainingPartnerDAO.getStatusList();
		return statusList;
	}
	@Override
	public List<StringStringBean> getModeOfTrainingList() {
		System.out.println("TrainingPartnerServiceImpl");
		List<StringStringBean> modeoftraininglist = trainingPartnerDAO.getModeOfTrainingList();
		return modeoftraininglist;
	}
	@Override
	public List<CourseName> getCourseNameList(){
		return  trainingPartnerDAO.getCourseNameList();
	}

	@Override
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList() {
		return  trainingPartnerDAO.getPostVacancyTrainingList();
	}

	@Override
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		return  trainingPartnerDAO.saveVacancy(postVacancyTrainingCenterBean);
	}

	@Override
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		return trainingPartnerDAO.getAppliedCount(postVacancyTrainingCenterBean);
	}

	@Override
	public void updateApplicationStatusForEnrolledVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		trainingPartnerDAO.updateApplicationStatusForEnrolledVacancy(postVacancyTrainingCenterBean);
		
	}

	@Override
	public PostVacancyTrainingCenterBean getApplicationStatusBean(String loginId,int coursename, int cousertype) {
		return trainingPartnerDAO.getApplicationStatusBean(loginId,coursename, cousertype);
	}

	@Override
	public void updateUpcomingTrainingsStatus(int id) {
		trainingPartnerDAO.updateUpcomingTrainingsStatus(id);
	}
	@Override
	public List<TrainingPartnerSearch> getTrainingPartnerDetails(int trainingPartnerId){
		return trainingPartnerDAO.getTrainingPartnerDetails(trainingPartnerId);
	}
}
