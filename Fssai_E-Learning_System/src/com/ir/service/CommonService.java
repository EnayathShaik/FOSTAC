package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;

public interface CommonService {
	
	public String getCourseTrainingType(String courseNameId);
	
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
}
