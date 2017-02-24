package com.ir.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactFormAssessor;
import com.ir.form.ContactTrainee;
import com.ir.form.RegistrationFormAssessor;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.AssessmentAgency;
import com.ir.model.CourseEnrolled;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.State;
import com.ir.model.Title;

public interface RegistrationServiceAssessor {
	@Transactional
	public List<State> loadState();
	
	@Transactional
	public List<Title> loadTitle();

	@Transactional
	public List<CourseName> basicCourseName();

	@Transactional
	public String registerPersonalInformationAssessor(RegistrationFormAssessor registrationFormAssessor);

	@Transactional
	public List<ManageAssessmentAgency> loadAssessmentAgency();

	@Transactional
	public String UpdateAssessor(RegistrationFormAssessor registrationFormAssessor, int loginId);

	@Transactional
	public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id);

	/*public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id);*/
	@Transactional
	String contactAssesorSave(ContactTrainee contactTrainee, String id);

	@Transactional
	public boolean changePasswordASSSave(ChangePasswordForm changePasswordForm, String id);

// Rishi
	//public String contactAssesorSave(ContactTrainee contactTrainee, String id);

	/*public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id);*/
	@Transactional
	public PersonalInformationAssessor fullDetailAssessor(int id );

}
