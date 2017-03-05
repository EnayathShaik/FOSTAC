package com.ir.dao;

import java.util.List;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.RegistrationFormAssessor;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.State;
import com.ir.model.Title;

public interface RegistrationAssessorDAO {

	String register(RegistrationFormAssessor registrationFormAssessor);

	List<State> loadState();

	List<Title> loadTitle();

	List<CourseName> basicCourseName();
	
	List<ManageAssessmentAgency> loadAssessmentAgency();

	String updateAssessor(RegistrationFormAssessor registrationFormAssessor, int loginId);

	State getState(int id);

	District getDistrict(int id);

	City getCity(int id);

	Title getTitle(int id);

	ManageAssessmentAgency getAssessmentAgencyName(int id);
	// Rishi
	String cotactAssessorSave(ContactTrainee contactTrainee, String id);

	boolean cotactAssessorSave(ChangePasswordForm changePasswordForm, String id);
	public PersonalInformationAssessor fullDetailAssesser(int id );

	/*String cotactAssessorSave(ContactFormAssessor contactFormAssessor, int id);*/

	// Rishi
}
