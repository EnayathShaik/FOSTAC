package com.ir.service.impl;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ir.dao.RegistrationDAO;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.RegisterTraineeInformationFull;
import com.ir.service.RegistrationServiceTrainee;


@Component("registrationService")
@Service
public class RegistrationServiceImpl implements RegistrationServiceTrainee{
	@Autowired
	@Qualifier("registrationDAO")
	RegistrationDAO registrationDAO; 

	
	@Override
	@Transactional
	public RegisterTraineeInformationFull registerTraineeInformationFull(RegistrationFormTrainee registrationFormTrainee) 
			//throws UserAlreadRegisteredException {
	{
		System.out.println("RegistrationServiceImpl [register] begin ");
		System.out.println(registrationFormTrainee.getAadharNumber());
		System.out.println(registrationFormTrainee.getBusinessAddressLine1());
		
		registrationDAO.register(registrationFormTrainee);
		return null;
		
		/*PersonalInformationTrainee registrationFormTrainee1=new PersonalInformationTrainee();
		registrationFormTrainee1.setFirstName(registrationFormTrainee.getFirstName());
		registrationFormTrainee1 = registrationDAO.registerTrainee(registrationFormTrainee1);
		System.out.println("RegistrationServiceImpl [register] begin ");*/
		
		
	}


	@Override
	@Transactional
	public String registerTraineeInformationFullIdCheck(
			RegistrationFormTrainee registrationFormTrainee) {
		System.out.println("RegistrationServiceImpl user id check begin ");
		String ret = null;
		
		String registerTraineeInformationFullIdCheck = registrationDAO.registerUserIdCheck(registrationFormTrainee);
		if(registerTraineeInformationFullIdCheck !=  null){
			ret = "already";
		}else{
			ret = null;
		}
		System.out.println("RegistrationServiceImpl user id check begin *** :" + ret);
		return ret;
	}

	@Override
	@Transactional
	public String registerPersonalInformationTrainee(
			RegistrationFormTrainee registrationFormTrainee) {
		String personalInformationTrainee = registrationDAO.registerPersonalInformationTrainee(registrationFormTrainee);
		return personalInformationTrainee;
	}
	
}
