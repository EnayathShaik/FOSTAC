package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;

public interface TrainerContactService {

	// Rishi
	@Transactional
	String contactTrainerSave(ContactTrainee contactTrainer, int id);

	@Transactional
	boolean changePasswordTrainerSave(ChangePasswordForm changePasswordForm, String id);

	@Transactional
	String contactTrainerSave(ContactTrainee contactTrainer, String id);
	// Rishi
	

}
