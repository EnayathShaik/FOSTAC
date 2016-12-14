package com.ir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.ir.dao.RegistrationTrainerDAO;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.service.RegistrationServiceTrainer;


@Component("registrationServiceTrainer")
public class RegistrationServiceTrainerImpl implements RegistrationServiceTrainer{
	
	@Autowired
	@Qualifier("registrationTrainerDAO")
	RegistrationTrainerDAO registrationTrainerDAO; 

	@Override
	public String registerPersonalInformationTrainer(RegistrationFormTrainer registrationFormTrainer) {
		// TODO Auto-generated method stub
		String personalInformationTrainer = registrationTrainerDAO.register(registrationFormTrainer);
		return personalInformationTrainer;
	}
	@Override
	public String UpdateTrainer(RegistrationFormTrainer registrationFormTrainer, int id) {
		// TODO Auto-generated method stub
		String personalInformationTrainer = registrationTrainerDAO.updatetrainer(registrationFormTrainer, id);
		return personalInformationTrainer;
	}
	//by Rishi
	@Override
	public long basicTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid){
			long basicCouseTrainer1 = registrationTrainerDAO.basicCourseTrainer(courseEnrolledUserForm,loginid);
		return basicCouseTrainer1;
	}
	
	@Override
	public long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		long basicCouseTrainer1 = registrationTrainerDAO.advanceTrainerSave(courseEnrolledUserForm,loginid);
		return basicCouseTrainer1;
	}
	@Override
	public long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		long basicCouseTrainer1 = registrationTrainerDAO.specialTrainerSave(courseEnrolledUserForm,loginid);
		return basicCouseTrainer1;
	}
	//by Rishi
}
