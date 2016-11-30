package com.ir.service;

import java.util.List;

import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;

public interface TrainingPartnerService {

	List<PersonalInformationTrainingPartner> trainingCenterList();

	List<CourseType> courseTypeList();

	String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id);

}
