package com.ir.dao;

import java.util.List;

import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationTrainer;

public interface UpdateDAO {

	List<PersonalInformationTrainer> FullInformation(LoginDetails loginDetails);

}
