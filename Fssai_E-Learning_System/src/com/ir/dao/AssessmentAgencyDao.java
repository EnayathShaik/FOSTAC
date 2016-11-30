package com.ir.dao;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;

public interface AssessmentAgencyDao {

	// Rishi
	String contactSave(ContactTrainee contactTrainee  , String id);

	boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	
	// Rishi
}
