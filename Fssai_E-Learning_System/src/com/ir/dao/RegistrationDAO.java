package com.ir.dao;

import com.ir.form.RegistrationFormTrainee;
import com.ir.model.RegisterTraineeInformationFull;
public interface RegistrationDAO {

	public RegisterTraineeInformationFull register(RegistrationFormTrainee registrationFormTrainee)  ;
	public String registerUserIdCheck(RegistrationFormTrainee registrationFormTrainee) ;
	public String registerPersonalInformationTrainee(
			RegistrationFormTrainee registrationFormTrainee) ;
}
