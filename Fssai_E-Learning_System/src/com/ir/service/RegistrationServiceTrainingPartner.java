package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.RegistrationFormTrainingPartner;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;

public interface RegistrationServiceTrainingPartner {
	
	@Transactional
	public String registerPersonalInformationTrainer(RegistrationFormTrainingPartner registrationFormTrainingPartner);

	@Transactional
	public List<State> loadState();

	@Transactional
	public List<Title> loadTitle();

	@Transactional
	public List<CourseName> basicCourseName();

	@Transactional
	public List<ManageTrainingPartner> trainingPartnerNameList();

	@Transactional
	public String registerPersonalInformationTrainingPartner(
			RegistrationFormTrainingPartner registrationFormTrainingPartner);

	@Transactional
	public List<ManageTrainingPartner> trainingCenterList();

	@Transactional
	public String UpdateTrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner, Integer ss);

	@Transactional
	public String contactTraineeSave(ContactTrainee contactTrainee, String id);

	@Transactional
	public String postVacancyTrainingCenter(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	@Transactional
	public List<CourseType> courseTypeList();

	@Transactional
	public List<CourseName> courseNameList();
	// Rishi
	@Transactional
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);
	
	@Transactional
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId);
	// Rishi end
}
