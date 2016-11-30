package com.ir.service;

import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;

public interface RegistrationServiceTrainer {
	
	public String registerPersonalInformationTrainer(RegistrationFormTrainer registrationFormTrainer);
	public String UpdateTrainer(RegistrationFormTrainer registrationFormTrainer,int id);
// Rishi	
public long basicTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, String loginid);
	public long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, String loginid);
	public long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, String loginid);
// Rishi
}
