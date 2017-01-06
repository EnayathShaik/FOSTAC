package com.ir.service;

import java.util.List;
import java.util.Set;

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
	
	public List<State> loadState();

	public List<Title> loadTitle();

	public List<CourseName> basicCourseName();

	public String registerPersonalInformationAssessor(RegistrationFormAssessor registrationFormAssessor);

	public List<ManageAssessmentAgency> loadAssessmentAgency();

	public String UpdateAssessor(RegistrationFormAssessor registrationFormAssessor, int loginId);

	public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id);

	/*public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id);*/
	String contactAssesorSave(ContactTrainee contactTrainee, String id);

	public boolean changePasswordASSSave(ChangePasswordForm changePasswordForm, String id);

// Rishi
	//public String contactAssesorSave(ContactTrainee contactTrainee, String id);

	/*public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id);*/
	
	public PersonalInformationAssessor fullDetailAssessor(int id );

}
