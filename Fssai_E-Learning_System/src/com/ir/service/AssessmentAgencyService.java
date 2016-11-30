package com.ir.service;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;

public interface AssessmentAgencyService {

// Rishi
	String contactAssessorSave(ContactTrainee contactTrainee , String id);


	boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	// Rishi
}
