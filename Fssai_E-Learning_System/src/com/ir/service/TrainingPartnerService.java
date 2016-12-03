package com.ir.service;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;

public interface TrainingPartnerService {

	public List<PersonalInformationTrainingPartner> trainingCenterList();

	public List<CourseType> courseTypeList();

	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id);
	public List<CourseType> courseTypes();
	public List<IntStringBean> getTrainerList();
	public List<CourseName> getCourseNameList();
	public List<StringStringBean> getStatusList();
	public List<StringStringBean> getModeOfTrainingList();
}
