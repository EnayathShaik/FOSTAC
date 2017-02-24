package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.trainingPartner.TrainingPartnerSearch;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.Utility;

public interface TrainingPartnerService {
	@Transactional
	public List<PersonalInformationTrainingPartner> trainingCenterList();
	
	@Transactional
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList(Integer userId);
	
	@Transactional
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,Integer profileID, Integer userId);

	@Transactional
	public List<CourseType> courseTypeList();

	@Transactional
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	@Transactional
	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	public List<CourseType> courseTypes();
	
	@Transactional
	public List<IntStringBean> getTrainerList();
	
	@Transactional
	public List<IntStringBean> getTraineeList();
	
	@Transactional
	public List<IntStringBean> getTrainingCenterList(Integer userId,Integer profileId);
	
	@Transactional
	public List<IntStringBean> getAssessorList();
	
	@Transactional
	public List<CourseName> getCourseNameList();
	
	@Transactional
	public List<StringStringBean> getStatusList();
	
	@Transactional
	public List<StringStringBean> getModeOfTrainingList();
	
	@Transactional
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	@Transactional
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	@Transactional
	public void updateApplicationStatusForEnrolledVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	@Transactional
	public PostVacancyTrainingCenterBean getApplicationStatusBean(String loginId,int coursename, int cousertype);
	
	@Transactional
	public void updateUpcomingTrainingsStatus(int id);
	
	@Transactional
	public List<PostVacancyTrainingCenterBean> getTrainingCalenderList(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	
	@Transactional
	public List<TrainingPartnerSearch> getTrainingPartnerDetails(int trainingPartnerId);
	
	@Transactional
	String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm);
	
	@Transactional
	public void cancelTrainingCalendar(int id);
	
	@Transactional
	public void setTrainingCalanderDeatils(TrainingCalendarForm trainingCalendarForm , String loginId);
	
	@Transactional
	public List<IntStringBean> loadAssessmentAgency();
}
