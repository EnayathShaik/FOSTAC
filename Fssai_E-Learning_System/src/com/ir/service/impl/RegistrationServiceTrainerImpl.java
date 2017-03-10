package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ir.dao.RegistrationTrainerDAO;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainer;
import com.ir.service.RegistrationServiceTrainer;


@Component("registrationServiceTrainer")
@Service
public class RegistrationServiceTrainerImpl implements RegistrationServiceTrainer{
	
	@Autowired
	@Qualifier("registrationTrainerDAO")
	RegistrationTrainerDAO registrationTrainerDAO; 

	@Override
	@Transactional
	public String registerPersonalInformationTrainer(RegistrationFormTrainer registrationFormTrainer) {
		// TODO Auto-generated method stub
		String personalInformationTrainer = registrationTrainerDAO.register(registrationFormTrainer);
		return personalInformationTrainer;
	}
	@Override
	@Transactional
	public String UpdateTrainer(RegistrationFormTrainer registrationFormTrainer, int id) {
		// TODO Auto-generated method stub
		String personalInformationTrainer = registrationTrainerDAO.updatetrainer(registrationFormTrainer, id);
		return personalInformationTrainer;
	}
	//by Rishi
	@Override
	@Transactional
	public long basicTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid){
			long basicCouseTrainer1 = registrationTrainerDAO.basicCourseTrainer(courseEnrolledUserForm,loginid);
		return basicCouseTrainer1;
	}
	
	@Override
	@Transactional
	public long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		long basicCouseTrainer1 = registrationTrainerDAO.advanceTrainerSave(courseEnrolledUserForm,loginid);
		return basicCouseTrainer1;
	}
	@Override
	@Transactional
	public long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		long basicCouseTrainer1 = registrationTrainerDAO.specialTrainerSave(courseEnrolledUserForm,loginid);
		return basicCouseTrainer1;
	}
	@Override
	@Transactional
	public PersonalInformationTrainer FullDetailTrainer(int loginId) {
		PersonalInformationTrainer personalInformationTrainer = registrationTrainerDAO.fullDetailtrainer(loginId);
		return personalInformationTrainer;
	}
	
	
	@Override
	@Transactional
	public List<ManageTrainingPartner> trainingPartnerList() {
		List<ManageTrainingPartner> trainingPartnerList = registrationTrainerDAO.trainingPartnerList();
		return trainingPartnerList;
	}
	
	
	
}
