package com.ir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.CommonDao;
import com.ir.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	@Qualifier("commonDao")
	CommonDao commonDao; 
	
	@Override
	public String getCourseTrainingType(String courseNameId){
		String modeOfTraining = commonDao.getCourseTrainingType(courseNameId);
		return modeOfTraining;
	}
}
