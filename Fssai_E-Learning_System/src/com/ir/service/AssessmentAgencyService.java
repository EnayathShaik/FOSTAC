package com.ir.service;

import java.util.List;
import java.util.Map;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;

public interface AssessmentAgencyService {
	
	String contactAssessorSave(ContactTrainee contactTrainee , String id);
	
	boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId);
	
	public List<CourseType> courseTypeList();
	
	
	public Map<String , String> assessorNameMap(int AssessmentAgency , int profileId);

}
