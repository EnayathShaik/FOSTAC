package com.ir.dao;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;

public interface TrainerContactDao {
	
	// Rishi
	String contactTrainerSave(ContactTrainee contactTrainee, String id);

	boolean changePasswordTrainerSave(ChangePasswordForm changePasswordForm, String id);

//	String contactTrainerSave(ContactTrainee contactTrainee, String id);
	// Rishi

}
