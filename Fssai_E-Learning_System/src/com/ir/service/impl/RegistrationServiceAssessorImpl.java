package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ir.dao.RegistrationAssessorDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactFormAssessor;
import com.ir.form.ContactTrainee;
import com.ir.form.RegistrationFormAssessor;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.RegistrationServiceAssessor;



@Component("registrationServiceTrainer")
@Service
public class RegistrationServiceAssessorImpl implements RegistrationServiceAssessor{
	
	@Autowired
	@Qualifier("registrationAssessorDAO")
	RegistrationAssessorDAO registrationAssessorDAO; 


	@Override
	@Transactional
	public List<State> loadState() {
		List<State> listState = registrationAssessorDAO.loadState();
		return listState;
	}

	@Override
	@Transactional
	public List<Title> loadTitle() {
		List<Title> titleList = registrationAssessorDAO.loadTitle();
		return titleList;
	}

	@Override
	@Transactional
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
				List<CourseName> basicCourseName= registrationAssessorDAO.basicCourseName();
				return basicCourseName;
	}

	@Override
	@Transactional
	public String registerPersonalInformationAssessor(RegistrationFormAssessor registrationFormAssessor ) {
		String personalInformationassessor = registrationAssessorDAO.register(registrationFormAssessor );
		return personalInformationassessor;
	}

	@Override
	@Transactional
	public List<ManageAssessmentAgency> loadAssessmentAgency() {
		List<ManageAssessmentAgency> loadAssessmentAgency = registrationAssessorDAO.loadAssessmentAgency();
		return loadAssessmentAgency;
	}

	@Override
	@Transactional
	public String UpdateAssessor(RegistrationFormAssessor registrationFormAssessor, int loginId) {
		String personalInformationassessor = registrationAssessorDAO.updateAssessor(registrationFormAssessor,loginId);
		return personalInformationassessor;
	}


	
	// Rishi
	@Override
	@Transactional
	public String contactAssesorSave(ContactTrainee contactTrainee, String id) {
		String contactFormAssessor1 = registrationAssessorDAO.cotactAssessorSave(contactTrainee,id);
		return contactFormAssessor1;
	}

	@Override
	@Transactional
	public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public boolean changePasswordASSSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePassword = registrationAssessorDAO.cotactAssessorSave(changePasswordForm,id);
		return changePassword;
	}

	@Override
	@Transactional
	public PersonalInformationAssessor fullDetailAssessor(int id) {
		PersonalInformationAssessor personalInformationAssessor = registrationAssessorDAO.fullDetailAssesser(id);
		return personalInformationAssessor;
	}


	
}
