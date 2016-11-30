package com.ir.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ir.dao.RegistrationDAO;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.RegisterTraineeInformationFull;
import com.ir.service.RegistrationServiceTrainee;


@Component("registrationService")
public class RegistrationServiceImpl implements RegistrationServiceTrainee{
	@Autowired
	@Qualifier("registrationDAO")
	RegistrationDAO registrationDAO; 

	
	@Override
	public RegisterTraineeInformationFull registerTraineeInformationFull(RegistrationFormTrainee registrationFormTrainee) 
			//throws UserAlreadRegisteredException {
	{
		System.out.println("RegistrationServiceImpl [register] begin ");
		System.out.println(registrationFormTrainee.getAadharNumber());
		System.out.println(registrationFormTrainee.getBusinessAddressLine1());
		
		RegisterTraineeInformationFull registerTraineeInformationFull = registrationDAO.register(registrationFormTrainee);
		return null;
		
		/*PersonalInformationTrainee registrationFormTrainee1=new PersonalInformationTrainee();
		registrationFormTrainee1.setFirstName(registrationFormTrainee.getFirstName());
		registrationFormTrainee1 = registrationDAO.registerTrainee(registrationFormTrainee1);
		System.out.println("RegistrationServiceImpl [register] begin ");*/
		
		
	}


	@Override
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
	public String registerPersonalInformationTrainee(
			RegistrationFormTrainee registrationFormTrainee) {
		String personalInformationTrainee = registrationDAO.registerPersonalInformationTrainee(registrationFormTrainee);
		return personalInformationTrainee;
	}
	
}
