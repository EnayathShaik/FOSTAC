package com.ir.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.ir.form.LoginForm;
import com.ir.model.CourseEnrolled;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.TrainingPartner;

public interface LoginService {
	
	@Transactional
	public LoginDetails login(LoginForm loginForm);

	@Transactional
	public List<CourseEnrolled> courseEnrolledList();

	@Transactional
	public PersonalInformationTrainee FullDetail(int loginId);

	@Transactional
	public List<TrainingPartner> trainingPartnerCountList();

	@Transactional
	public ManageAssessmentAgency FullDetailAssessmentAgency(int id);

	@Transactional
	public PersonalInformationAssessor fullDetailAssessor(int id );

	@Transactional
	public ManageTrainingPartner FullDetailTP(int id);
	
	@Transactional
	public PersonalInformationTrainer FullDetailTrainer(int loginId);

	@Transactional
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId);
	
}
