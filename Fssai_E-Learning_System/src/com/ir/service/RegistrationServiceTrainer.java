package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.PersonalInformationTrainer;

public interface RegistrationServiceTrainer {
	@Transactional
	public String registerPersonalInformationTrainer(RegistrationFormTrainer registrationFormTrainer);
	
	@Transactional
	public String UpdateTrainer(RegistrationFormTrainer registrationFormTrainer,int id);
	
	@Transactional
	public long basicTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	
	@Transactional
	public long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	
	@Transactional
	public long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	
	@Transactional
	public PersonalInformationTrainer FullDetailTrainer(int loginId);
}
