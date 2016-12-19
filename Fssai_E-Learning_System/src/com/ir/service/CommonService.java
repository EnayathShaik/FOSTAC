package com.ir.service;

import com.ir.form.ChangePasswordForm;

public interface CommonService {

	public String getCourseTrainingType(String courseNameId);
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
}
