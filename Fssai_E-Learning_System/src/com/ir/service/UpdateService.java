package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.form.RegistrationFormTrainer;
import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationTrainer;

public interface UpdateService {
	@Transactional
	List<PersonalInformationTrainer> UpdateService(LoginDetails loginDetails);
}
