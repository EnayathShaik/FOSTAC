package com.ir.dao.impl;

import org.springframework.stereotype.Service;

import com.ir.dao.TrainerContactDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;

@Service
public class TrainerContactDaoIMPL implements TrainerContactDao{

	@Override
	public String contactTrainerSave(ContactTrainee contactTrainee, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePasswordTrainerSave(ChangePasswordForm changePasswordForm, String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
