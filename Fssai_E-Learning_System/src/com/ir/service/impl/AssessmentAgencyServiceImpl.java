package com.ir.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.AssessmentAgencyDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.service.AssessmentAgencyService;

public class AssessmentAgencyServiceImpl implements AssessmentAgencyService {

	@Autowired
	@Qualifier("assessmentAgencyDao")
	AssessmentAgencyDao assessmentAgencyDao; 
	
	// Rishi
	@Override
	public String contactAssessorSave(ContactTrainee contactTrainee  , String id) {
		String contactAssessorSave = assessmentAgencyDao.contactSave(contactTrainee , id);
		return contactAssessorSave;
	}


	@Override
	public boolean changePasswordData(ChangePasswordForm changePasswordForm,String id) {
		boolean confirmaPass = assessmentAgencyDao.changePasswordData(changePasswordForm , id);
		return confirmaPass;
	}

	// Rishi
}
