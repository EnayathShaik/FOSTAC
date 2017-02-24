package com.ir.service;


import javax.transaction.Transactional;

import com.ir.form.RegistrationFormTrainee;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.RegisterTraineeInformationFull;



public interface RegistrationServiceTrainee {
	@Transactional
	public RegisterTraineeInformationFull registerTraineeInformationFull(RegistrationFormTrainee registrationFormTrainee); 
	@Transactional
	public String registerTraineeInformationFullIdCheck(RegistrationFormTrainee registrationFormTrainee) ;
	@Transactional
	public String registerPersonalInformationTrainee(RegistrationFormTrainee registrationFormTrainee);

}
