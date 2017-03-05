package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;

public interface CommonService {
	
	public String getCourseTrainingType(String courseNameId);
	
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
	
	public String checkAadhar(String aadhar , String tableName);
	
	public List getCourseName( String courseName);
}
