package com.ir.service;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.assessmentagency.AssessmentAgencyForm;

public interface AssessmentAgencyService {

	String contactAssessorSave(ContactTrainee contactTrainee , String id);
	boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId);
}
