package com.ir.dao;

import java.util.List;

import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.State;
import com.ir.model.Title;

public interface RegistrationTrainerDAO {
	String register(RegistrationFormTrainer registrationFormTrainer);
	String updatetrainer(RegistrationFormTrainer registrationFormTrainer,int id);
	City getCity(int id);
	State getState(int id);
	District getDistrict(int id);
	Title getTitle(int id);
	ManageTrainingPartner getTP(int id);
	long basicCourseTrainer(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid);
	public PersonalInformationTrainer fullDetailtrainer(int loginId);
	public List<ManageTrainingPartner> trainingPartnerList();

}
