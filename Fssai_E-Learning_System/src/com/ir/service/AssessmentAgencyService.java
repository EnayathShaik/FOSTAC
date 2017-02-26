package com.ir.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;

public interface AssessmentAgencyService {
	@Transactional
	String contactAssessorSave(ContactTrainee contactTrainee , String id);
	@Transactional
	boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	@Transactional
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId);
	@Transactional
	public List<CourseType> courseTypeList();
	
	@Transactional
	public Map<String , String> assessorNameMap(int AssessmentAgency);

}
