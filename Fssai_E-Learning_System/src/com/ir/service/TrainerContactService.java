package com.ir.service;

import javax.transaction.Transactional;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;

public interface TrainerContactService {

	// Rishi
	
	String contactTrainerSave(ContactTrainee contactTrainer, int id);

	
	boolean changePasswordTrainerSave(ChangePasswordForm changePasswordForm, String id);

	
	String contactTrainerSave(ContactTrainee contactTrainer, String id);
	// Rishi
	

}
