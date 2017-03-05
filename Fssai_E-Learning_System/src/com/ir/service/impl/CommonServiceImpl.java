package com.ir.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.CommonDao;
import com.ir.form.ChangePasswordForm;
import com.ir.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	@Qualifier("commonDao")
	CommonDao commonDao; 
	
	@Override
	@Transactional
	public String getCourseTrainingType(String courseNameId){
		String modeOfTraining = commonDao.getCourseTrainingType(courseNameId);
		return modeOfTraining;
	}
	@Override
	@Transactional
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordAssesorSave= commonDao.changePasswordSave(changePasswordForm , id);
		return changePasswordAssesorSave;
	}
	
	@Override
	@Transactional
	public String checkAadhar(String aadhar , String tableName){
		String modeOfTraining = commonDao.checkAadhar(aadhar , tableName);
		return modeOfTraining;
	}
}
