package com.ir.dao;

import java.util.List;

import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;

public interface TrainingPartnerDao {

	List<PersonalInformationTrainingPartner> trainingCenterList();

	List<CourseType> courseTypeList();

	String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	CourseType getCourseType(int id);

	CourseName getCourseName(int id);

	PersonalInformationTrainingPartner getPersonalInformationTrainingPartner(int id);

	boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id);

}
