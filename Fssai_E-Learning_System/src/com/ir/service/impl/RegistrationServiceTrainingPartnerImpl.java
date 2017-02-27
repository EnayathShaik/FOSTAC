package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
@Service
public class RegistrationServiceTrainingPartnerImpl implements RegistrationServiceTrainingPartner{
	
	@Autowired
	@Qualifier("registrationTrainingPartnerDAO")
	RegistrationTrainingPartnerDAO registrationTrainingPartnerDAO; 

	@Override
	@Transactional
	public String registerPersonalInformationTrainer(RegistrationFormTrainingPartner registrationFormTrainingPartner) {
		// TODO Auto-generated method stub
		String personalInformationTrainingPartner = registrationTrainingPartnerDAO.register(registrationFormTrainingPartner);
		return personalInformationTrainingPartner;
	}

	@Override
	@Transactional
	public List<State> loadState() {
		// TODO Auto-generated method stub
		List<State> listState = registrationTrainingPartnerDAO.loadState();
		return listState;
	}

	@Override
	@Transactional
	public List<Title> loadTitle() {
		List<Title> titleList = registrationTrainingPartnerDAO.loadTitle();
		return titleList;
	}

	@Override
	@Transactional
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
				List<CourseName> basicCourseName= registrationTrainingPartnerDAO.basicCourseName();
				return basicCourseName;
	}

	@Override
	@Transactional
	public List<ManageTrainingPartner> trainingPartnerNameList() {
		List<ManageTrainingPartner> trainingPartnerNameList= registrationTrainingPartnerDAO.trainingPartnerNameList();
		return trainingPartnerNameList;
	}

	@Override
	@Transactional
	public String registerPersonalInformationTrainingPartner(
			RegistrationFormTrainingPartner registrationFormTrainingPartner) {
		String registerPersonalInformationTrainingPartner = registrationTrainingPartnerDAO.registerTrainingPartner(registrationFormTrainingPartner);
		return registerPersonalInformationTrainingPartner;
	}

	@Override
	@Transactional
	public List<ManageTrainingPartner> trainingCenterList() {
		List<ManageTrainingPartner> trainingCenterList= registrationTrainingPartnerDAO.trainingCenterList();
		return trainingCenterList;
	}
	@Override
	@Transactional
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
	@Transactional
	public String contactTraineeSave(ContactTrainee contactTrainee, String id) {
		String contactTraineeSave = registrationTrainingPartnerDAO.contactTraineeSave(contactTrainee , id);
		return contactTraineeSave;
	}

	@Override
	@Transactional
	public String postVacancyTrainingCenter(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		String postVacancyTrainingCenter = registrationTrainingPartnerDAO.postVacancyTrainingCenter(postVacancyTrainingCenterForm);
		return postVacancyTrainingCenter;
	}

	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = registrationTrainingPartnerDAO.courseTypeList();
		return courseTypeList;
	}

	@Override
	@Transactional
	public List<CourseName> courseNameList() {
		List<CourseName> courseNameList = registrationTrainingPartnerDAO.courseNameList();
		return courseNameList;
	}
	@Override
	@Transactional
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTCSave = registrationTrainingPartnerDAO.changePasswordTCSave(changePasswordForm , id);
		return changePasswordTCSave;
	}
	
	@Override
	@Transactional
	public PersonalInformationTrainingPartner FullDetailtrainingpartner(int loginId) {
		// TODO Auto-generated method stub
		PersonalInformationTrainingPartner personalInformationTrainingPartner = registrationTrainingPartnerDAO.fulldetailtainingpartner(loginId);
		return personalInformationTrainingPartner;
	}
	// Rishi
	
}
