package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.PersonalInformationTrainer;

public interface RegistrationServiceTrainer {
	
	public String registerPersonalInformationTrainer(RegistrationFormTrainer registrationFormTrainer);
	
	
	public String UpdateTrainer(RegistrationFormTrainer registrationFormTrainer,int id);
	
	
	public long basicTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	
	
	public long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	
	
	public long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	
	
	public PersonalInformationTrainer FullDetailTrainer(int loginId);
}
