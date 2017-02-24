package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;

public interface CommonService {
	@Transactional
	public String getCourseTrainingType(String courseNameId);
	
	@Transactional
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
}
