package com.ir.service;

import java.util.List;

import com.ir.form.LoginForm;
import com.ir.model.CourseEnrolled;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.TrainingPartner;

public interface LoginService {
	
	
	public LoginDetails login(LoginForm loginForm);
	
	public boolean isAction();

	
	public List<CourseEnrolled> courseEnrolledList();

	
	public PersonalInformationTrainee FullDetail(int loginId);

	
	public List<TrainingPartner> trainingPartnerCountList();
	
	public String noMore(String status);

	
	public ManageAssessmentAgency FullDetailAssessmentAgency(int id);

	
	public PersonalInformationAssessor fullDetailAssessor(int id );

	
	public ManageTrainingPartner FullDetailTP(int id);
	
	
	public PersonalInformationTrainer FullDetailTrainer(int loginId);

	
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId);
	
	public long getTraineeCount();
	public long getTrainerCount();
	public long getTrainingCenterCount();
	public long getAssessorCount();
	public long getTrainingPartnerCount();
	public long getAssessorAgencyCount();
	
	public String getTrainingEndDateOfTrainee(int loginId);
	
}
