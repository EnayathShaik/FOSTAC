package com.ir.service;

import java.util.List;

import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationTrainer;

public interface UpdateService {
	
	List<PersonalInformationTrainer> UpdateService(LoginDetails loginDetails);
}
