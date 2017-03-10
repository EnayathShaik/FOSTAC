package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.UpdateDAO;
import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationTrainer;
import com.ir.service.UpdateService;
@Service
public class UpdateServiceImpl implements UpdateService {

	
	@Autowired
	@Qualifier("updateDAO")
	private UpdateDAO updateDAO;
	
	@Override
	@Transactional
	public List<PersonalInformationTrainer> UpdateService(LoginDetails loginDetails) {
		List<PersonalInformationTrainer> personalInformationTrainer = updateDAO.FullInformation(loginDetails);
		return personalInformationTrainer;
	}


}
