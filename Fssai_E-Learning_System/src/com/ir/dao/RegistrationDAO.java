package com.ir.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.ir.form.RegistrationFormTrainee;
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.RegisterTraineeInformationFull;
import com.ir.model.State;
import com.ir.model.Title;


public interface RegistrationDAO {

	public RegisterTraineeInformationFull register(RegistrationFormTrainee registrationFormTrainee)  ;
	public String registerUserIdCheck(RegistrationFormTrainee registrationFormTrainee) ;
	public String registerPersonalInformationTrainee(
			RegistrationFormTrainee registrationFormTrainee) ;
	KindOfBusiness getKid(int id);
	State getState(int id);
	City getCity(int id);
	District getDistrict(int id);
	Title getTitle(int id);	
}
