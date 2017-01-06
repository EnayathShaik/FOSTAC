package com.ir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ir.dao.RegistrationTrainingPartnerDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.RegistrationFormTrainingPartner;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.RegistrationServiceTrainingPartner;


@Component("registrationServiceTrainingPartner")
public class RegistrationServiceTrainingPartnerImpl implements RegistrationServiceTrainingPartner{
	
	@Autowired
	@Qualifier("registrationTrainingPartnerDAO")
	RegistrationTrainingPartnerDAO registrationTrainingPartnerDAO; 

	@Override
	public String registerPersonalInformationTrainer(RegistrationFormTrainingPartner registrationFormTrainingPartner) {
		// TODO Auto-generated method stub
		String personalInformationTrainingPartner = registrationTrainingPartnerDAO.register(registrationFormTrainingPartner);
		return personalInformationTrainingPartner;
	}

	@Override
	public List<State> loadState() {
		// TODO Auto-generated method stub
		List<State> listState = registrationTrainingPartnerDAO.loadState();
		return listState;
	}

	@Override
	public List<Title> loadTitle() {
		List<Title> titleList = registrationTrainingPartnerDAO.loadTitle();
		return titleList;
	}

	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
				List<CourseName> basicCourseName= registrationTrainingPartnerDAO.basicCourseName();
				return basicCourseName;
	}

	@Override
	public List<ManageTrainingPartner> trainingPartnerNameList() {
		List<ManageTrainingPartner> trainingPartnerNameList= registrationTrainingPartnerDAO.trainingPartnerNameList();
		return trainingPartnerNameList;
	}

	@Override
	public String registerPersonalInformationTrainingPartner(
			RegistrationFormTrainingPartner registrationFormTrainingPartner) {
		String registerPersonalInformationTrainingPartner = registrationTrainingPartnerDAO.registerTrainingPartner(registrationFormTrainingPartner);
		return registerPersonalInformationTrainingPartner;
	}

	@Override
	public List<ManageTrainingPartner> trainingCenterList() {
		List<ManageTrainingPartner> trainingCenterList= registrationTrainingPartnerDAO.trainingCenterList();
		return trainingCenterList;
	}
	@Override
	public String UpdateTrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner, Integer id) {
		String registrationFormTrainingPartner1 = registrationTrainingPartnerDAO.updatetrainingPartner(registrationFormTrainingPartner, id);
		return registrationFormTrainingPartner1;
		
	}

	/*@Override
	public String contactTraineeSave(ContactTrainee contactTrainee, int id) {
		String contactTraineeSave = registrationTrainingPartnerDAO.contactTraineeSave(contactTrainee , id);
		return contactTraineeSave;
	}*/
	@Override
	public String contactTraineeSave(ContactTrainee contactTrainee, String id) {
		String contactTraineeSave = registrationTrainingPartnerDAO.contactTraineeSave(contactTrainee , id);
		return contactTraineeSave;
	}

	@Override
	public String postVacancyTrainingCenter(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		String postVacancyTrainingCenter = registrationTrainingPartnerDAO.postVacancyTrainingCenter(postVacancyTrainingCenterForm);
		return postVacancyTrainingCenter;
	}

	@Override
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = registrationTrainingPartnerDAO.courseTypeList();
		return courseTypeList;
	}

	@Override
	public List<CourseName> courseNameList() {
		List<CourseName> courseNameList = registrationTrainingPartnerDAO.courseNameList();
		return courseNameList;
	}
	@Override
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTCSave = registrationTrainingPartnerDAO.changePasswordTCSave(changePasswordForm , id);
		return changePasswordTCSave;
	}
	
	@Override
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId) {
		// TODO Auto-generated method stub
		PersonalInformationTrainingPartner personalInformationTrainingPartner = registrationTrainingPartnerDAO.fulldetailtainingpartner(loginId);
		return personalInformationTrainingPartner;
	}
	// Rishi
	
}
