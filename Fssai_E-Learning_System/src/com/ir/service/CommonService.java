package com.ir.service;

import java.util.List;

import com.ir.form.ChangePasswordForm;

public interface CommonService {
	
	public String getCourseTrainingType(String courseNameId);
	
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
	
	public String checkAadhar(String aadhar , String tableName);
	
	public List getCourseName( String courseName);
	public List getAssessorName( String assessorAgencyName);
	
	public String getCourseTrainingMode(String courseNmae);
}
