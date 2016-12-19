package com.ir.dao;

import com.ir.form.ChangePasswordForm;

public interface CommonDao {
	public String getCourseTrainingType(String courseNameId);
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id);
}
