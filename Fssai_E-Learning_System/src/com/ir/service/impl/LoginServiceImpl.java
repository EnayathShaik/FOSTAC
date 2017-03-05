package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.LoginDAO;
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
import com.ir.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired(required=true)
	@Qualifier(value="loginDAO")
	private LoginDAO loginDAO;

	@Override
	@Transactional
	public LoginDetails login(LoginForm loginForm) {
		LoginDetails loginDetails = loginDAO.login(loginForm);
		return loginDetails;
	}

	@Override
	@Transactional
	public List<CourseEnrolled> courseEnrolledList() {
		List<CourseEnrolled> courseEnrolledList= loginDAO.courseEnrolledList();
		return courseEnrolledList;
	}

	@Override
	@Transactional
	public PersonalInformationTrainee FullDetail(int loginId) {
		PersonalInformationTrainee personalInformationTrainee = loginDAO.fullDetail(loginId);
		return personalInformationTrainee;
	}
	

	@Override
	@Transactional
	public List<TrainingPartner> trainingPartnerCountList() {
		List<TrainingPartner> trainingPartnerCountList= loginDAO.trainingPartnerCountList();
		return trainingPartnerCountList;
	}

	@Override
	@Transactional
	public ManageAssessmentAgency FullDetailAssessmentAgency(int id) {
		ManageAssessmentAgency manageAssessmentAgency = loginDAO.fullDetailAssessmentAgency(id);
		return manageAssessmentAgency;
	}

	@Override
	@Transactional
	public PersonalInformationAssessor fullDetailAssessor(int id) {
		PersonalInformationAssessor personalInformationAssessor = loginDAO.fullDetailAssesser(id);
		return personalInformationAssessor;
	}

	@Override
	@Transactional
	public ManageTrainingPartner FullDetailTP(int id) {
		ManageTrainingPartner manageTrainingPartner = loginDAO.fullDetailTP(id);
		return manageTrainingPartner;
	}
	@Override
	@Transactional
	public PersonalInformationTrainer FullDetailTrainer(int loginId) {
		PersonalInformationTrainer personalInformationTrainer = loginDAO.fullDetailtrainer(loginId);
		return personalInformationTrainer;
	}
	@Override
	@Transactional
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId) {
		// TODO Auto-generated method stub
		PersonalInformationTrainingPartner personalInformationTrainingPartner = loginDAO.fulldetailtainingpartner(loginId);
		return personalInformationTrainingPartner;
	}
	
}
