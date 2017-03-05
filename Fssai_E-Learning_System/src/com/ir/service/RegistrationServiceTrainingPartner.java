package com.ir.service;

import java.util.List;

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
	
	
	public String registerPersonalInformationTrainer(RegistrationFormTrainingPartner registrationFormTrainingPartner);

	
	public List<State> loadState();

	
	public List<Title> loadTitle();

	
	public List<CourseName> basicCourseName();

	
	public List<ManageTrainingPartner> trainingPartnerNameList();

	
	public String registerPersonalInformationTrainingPartner(
			RegistrationFormTrainingPartner registrationFormTrainingPartner);

	
	public List<ManageTrainingPartner> trainingCenterList();

	
	public String UpdateTrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner, Integer ss);

	
	public String contactTraineeSave(ContactTrainee contactTrainee, String id);

	
	public String postVacancyTrainingCenter(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	
	public List<CourseType> courseTypeList();

	
	public List<CourseName> courseNameList();
	// Rishi
	
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id);
	
	
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId);
	// Rishi end
}
