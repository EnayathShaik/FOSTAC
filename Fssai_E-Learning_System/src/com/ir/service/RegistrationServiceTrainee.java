package com.ir.service;


import com.ir.form.RegistrationFormTrainee;
import com.ir.model.RegisterTraineeInformationFull;



public interface RegistrationServiceTrainee {
	
	public RegisterTraineeInformationFull registerTraineeInformationFull(RegistrationFormTrainee registrationFormTrainee); 
	
	public String registerTraineeInformationFullIdCheck(RegistrationFormTrainee registrationFormTrainee) ;
	
	public String registerPersonalInformationTrainee(RegistrationFormTrainee registrationFormTrainee);

}
