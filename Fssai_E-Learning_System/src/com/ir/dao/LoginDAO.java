package com.ir.dao;

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

public interface LoginDAO {

	public LoginDetails login(LoginForm loginForm);

	public List<CourseEnrolled> courseEnrolledList();

	public PersonalInformationTrainee fullDetail(int loginId);

	public List<TrainingPartner> trainingPartnerCountList();

	public ManageAssessmentAgency fullDetailAssessmentAgency(int id);

	public PersonalInformationAssessor fullDetailAssesser(int id );

	public ManageTrainingPartner fullDetailTP(int id);

	public PersonalInformationTrainer fullDetailtrainer(int loginId);

	public PersonalInformationTrainingPartner fulldetailtainingpartner(int id);
}
