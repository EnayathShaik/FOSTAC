package com.ir.service;


import javax.transaction.Transactional;

import com.ir.form.RegistrationFormTrainee;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.RegisterTraineeInformationFull;



public interface RegistrationServiceTrainee {
	
	public RegisterTraineeInformationFull registerTraineeInformationFull(RegistrationFormTrainee registrationFormTrainee); 
	
	public String registerTraineeInformationFullIdCheck(RegistrationFormTrainee registrationFormTrainee) ;
	
	public String registerPersonalInformationTrainee(RegistrationFormTrainee registrationFormTrainee);

}
