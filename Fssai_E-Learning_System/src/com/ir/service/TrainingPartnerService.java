package com.ir.service;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
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

public interface TrainingPartnerService {
	
	public List<PersonalInformationTrainingPartner> trainingCenterList();
	
	
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList(Integer userId);
	
	
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,Integer profileID, Integer userId);

	
	public List<CourseType> courseTypeList();

	
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	
	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id);
	
	
	public List<CourseType> courseTypes();
	
	
	public List<IntStringBean> getTrainerList();
	
	
	public List<IntStringBean> getTraineeList();
	
	
	public List<IntStringBean> getTrainingCenterList(Integer userId,Integer profileId);
	
	//getTrainingCenter
	
	public int getTrainingCenter(Integer userId,Integer profileId);
	
	
	public List<IntStringBean> getAssessorList();
	
	
	public List<CourseName> getCourseNameList();
	
	
	public List<StringStringBean> getStatusList();
	
	
	public List<StringStringBean> getModeOfTrainingList();
	
	
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	
	public void updateApplicationStatusForEnrolledVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	
	public PostVacancyTrainingCenterBean getApplicationStatusBean(String loginId,int coursename, int cousertype);
	
	
	public void updateUpcomingTrainingsStatus(int id);
	
	
	public List<PostVacancyTrainingCenterBean> getTrainingCalenderList(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	
	public List<TrainingPartnerSearch> getTrainingPartnerDetails(int trainingPartnerId);
	
	
	
	String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm);
	
	
	public void cancelTrainingCalendar(int id);
	
	
	public void setTrainingCalanderDeatils(TrainingCalendarForm trainingCalendarForm , String loginId);
	
	
	public List<IntStringBean> loadAssessmentAgency();
	
	
	public List<String> getBatchCodeList(int CourseCode);
	
	
	public List<String> getCertificateIdList(String CourseCode , String loginId);
	
	//getTrainingPartnerList
	
	public List getTrainingPartnerList(String searchData);
	
	//traineeCenterViewTraineeList
	
	public List traineeCenterViewTraineeList(String searchData);
	//searchMarkAttendance
	
	public List searchMarkAttendance(String searchData);
	
	//traineeCenterPaymentConfirmation
	
	public List traineeCenterPaymentConfirmation(String searchData);
	
	//trainingpartnermanagetrainer
	
	
	public List trainingpartnermanagetrainer(String searchData);
	
	//searchVacancy
	
	public List searchVacancy(String searchData);
	
	//updateAttendanceStatus
	
	public String updateAttendanceStatus(String searchData);
	
	public List SearchUpcomingTraining(String data);
	
	public List searchTrainingCenterList(String data);
	
	public List onLoadTrainingPartnerCenterId(String data);
	
	public String markTraineeAttendance(String rollNo);
	
	public String updateTrainingCalendar(String data);
	
	public List certificateForTraineeList(String data);
	
	public List searchDataTP(String data);
	
	public List editMTP(String data);
	
	public String updateMTP(String data);
	
	
	
}
