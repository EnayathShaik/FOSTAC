package com.ir.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.AssessmentAgencyDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;
import com.ir.service.AssessmentAgencyService;

public class AssessmentAgencyServiceImpl implements AssessmentAgencyService {

	@Autowired
	@Qualifier("assessmentAgencyDao")
	AssessmentAgencyDao assessmentAgencyDao; 
	
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
	@Override
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId){
		AssessmentAgencyForm assessmentAgencyForm = assessmentAgencyDao.getAssessmentAgencyForm(agencyId);
		return assessmentAgencyForm;
	}
	
	
	@Override
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = assessmentAgencyDao.courseTypeList();
		return courseTypeList;
	}
	
	
	
	@Override
	public Map<String , String> assessorNameMap(int agencyId) {
		Map<String , String>assessorName = assessmentAgencyDao.assessorNameMap(agencyId);
		return assessorName;
	}

}
