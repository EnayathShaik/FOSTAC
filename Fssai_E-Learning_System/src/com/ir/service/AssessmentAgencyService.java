package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.assessmentagency.AssessmentAgencyForm;

public interface AssessmentAgencyService {
	@Transactional
	String contactAssessorSave(ContactTrainee contactTrainee , String id);
	@Transactional
	boolean changePasswordData(ChangePasswordForm changePasswordForm, String id);
	@Transactional
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyId);
}
