package com.ir.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.AssessmentAgencyDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;
import com.ir.service.AssessmentAgencyService;
@Service
public class AssessmentAgencyServiceImpl implements AssessmentAgencyService {

	@Autowired
	@Qualifier("assessmentAgencyDao")
	AssessmentAgencyDao assessmentAgencyDao; 
	
	@Override
	@Transactional
	public String contactAssessorSave(ContactTrainee contactTrainee  , String id) {
		String contactAssessorSave = assessmentAgencyDao.contactSave(contactTrainee , id);
		return contactAssessorSave;
	}


	@Override
	@Transactional
	public boolean changePasswordData(ChangePasswordForm changePasswordForm,String id) {
		boolean confirmaPass = assessmentAgencyDao.changePasswordData(changePasswordForm , id);
		return confirmaPass;
	}
	@Override
	@Transactional
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId){
		AssessmentAgencyForm assessmentAgencyForm = assessmentAgencyDao.getAssessmentAgencyForm(agencyId);
		return assessmentAgencyForm;
	}
	
	
	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = assessmentAgencyDao.courseTypeList();
		return courseTypeList;
	}
	
	
	
	@Override
	@Transactional
	public Map<String , String> assessorNameMap(int agencyId , int profileId) {
		Map<String , String>assessorName = assessmentAgencyDao.assessorNameMap(agencyId , profileId);
		return assessorName;
	}

}
