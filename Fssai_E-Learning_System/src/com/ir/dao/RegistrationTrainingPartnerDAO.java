package com.ir.dao;

import java.util.List;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.RegistrationFormTrainingPartner;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.LoginDetails;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;

public interface RegistrationTrainingPartnerDAO {

	String register(RegistrationFormTrainingPartner registrationFormTrainingPartner);

	List<State> loadState();

	List<Title> loadTitle();

	List<CourseName> basicCourseName();

	List<ManageTrainingPartner> trainingPartnerNameList();

	String registerTrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner);

	List<ManageTrainingPartner> trainingCenterList();

	String updatetrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner, Integer id);

	String contactTraineeSave(ContactTrainee contactTrainee, String id);

	String postVacancyTrainingCenter(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm);

	CourseType getCourseType(int id);

	CourseName getCourseName(int id);

	List<CourseName> courseNameList();

	List<CourseType> courseTypeList();


	LoginDetails getLoginDetails(String string);

boolean changePasswordTCSave(ChangePasswordForm changePasswordForm, String id);
	// Rishi

PersonalInformationTrainingPartner getPersonalInformationTrainingPartner(int id);
public PersonalInformationTrainingPartner fulldetailtainingpartner(int id);




}
