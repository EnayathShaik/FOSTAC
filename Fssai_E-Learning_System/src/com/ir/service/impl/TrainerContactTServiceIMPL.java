package com.ir.service.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.TrainerContactDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.service.TrainerContactService;
@Service
public class TrainerContactTServiceIMPL implements TrainerContactService {

	@Autowired
	@Qualifier("trainerContactDao")
	TrainerContactDao trainerContactDao; 
	
	@Autowired
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;
	
	
	// Rishi
	@Override
	@Transactional
	public String contactTrainerSave(ContactTrainee contactTrainer, String id) {
		String contactTrainerSave = trainerContactDao.contactTrainerSave(contactTrainer , id);
			return contactTrainerSave;
		}



	@Override
	@Transactional
	public boolean changePasswordTrainerSave(ChangePasswordForm changePasswordForm, String id) {
		boolean contactTrainerSave = trainerContactDao.changePasswordTrainerSave(changePasswordForm , id);
		return contactTrainerSave;
	}



	@Override
	@Transactional
	public String contactTrainerSave(ContactTrainee contactTrainer, int id) {
		// TODO Auto-generated method stub
		return null;
	}
		//Rishi
	}


