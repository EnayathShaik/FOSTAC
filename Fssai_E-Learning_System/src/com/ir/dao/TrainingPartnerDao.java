package com.ir.dao;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.Utility;

public interface TrainingPartnerDao {

	public List<PersonalInformationTrainingPartner> trainingCenterList();
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList();
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);

	public List<CourseType> courseTypeList();

	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	public CourseType getCourseType(int id);

	public CourseName getCourseName(int id);

	public PersonalInformationTrainingPartner getPersonalInformationTrainingPartner(int id);

	boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id);
	public List<CourseType> courseTypes();
	public List<IntStringBean> getTrainerList();
	public List<CourseName> getCourseNameList();
	public List<StringStringBean> getStatusList();
	public List<StringStringBean> getModeOfTrainingList();
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	public void updateApplicationStatusForEnrolledVacancy(
			PostVacancyTrainingCenterBean postVacancyTrainingCenterBean);
	public PostVacancyTrainingCenterBean getApplicationStatusBean(String loginId,int coursename, int cousertype);


}
