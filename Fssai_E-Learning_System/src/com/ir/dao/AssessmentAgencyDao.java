package com.ir.dao;

import java.util.List;
import java.util.Map;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;

public interface AssessmentAgencyDao {

	public String contactSave(ContactTrainee contactTrainee  , String id);
	public boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId);
	public List<CourseType> courseTypeList();
	public Map<String , String> assessorNameMap(int agencyId , int profileId);
}
