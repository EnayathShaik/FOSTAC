package com.ir.dao;

import java.util.List;

import com.ir.form.ChangePasswordForm;

public interface CommonDao {
	public String getCourseTrainingType(String courseNameId);
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
	public String checkAadhar(String aadhar , String tableName);
	public List getCourseName(String courseName);
	//getAssessorName
	public List getAssessorName(String assessorAgencyName);
	//getCourseTrainingMode
	public String getCourseTrainingMode(String courseName);
}
