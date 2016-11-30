package com.ir.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.TrainerContactDao;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.ContactTraineee;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.SendContectMail;

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
