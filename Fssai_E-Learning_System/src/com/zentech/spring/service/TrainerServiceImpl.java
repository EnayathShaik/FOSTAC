package com.zentech.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.zentech.spring.dao.TrainerDAO;
import com.zentech.spring.hb.model.PersonalInformationTrainer;


public class TrainerServiceImpl implements TrainerService {
	private TrainerDAO TrainerDAO;
	
	
	
	public void setTrainerDAO(TrainerDAO TrainerDAO) {
		this.TrainerDAO = TrainerDAO;
	}

	
	
	
	//*************************** Register Trainer *****************************************************
	
	@Override
	@Transactional
	public void addPersonalInfoTrainer(PersonalInformationTrainer p) {
		// TODO Auto-generated method stub
		this.TrainerDAO.addPersonalInfoTrainer(p);
	}

	@Override
	@Transactional
	public void updatePersonalInfoTrainer(PersonalInformationTrainer p) {
		// TODO Auto-generated method stub
		this.TrainerDAO.updatePersonalInfoTrainer(p);
	}

	@Override
	@Transactional
	public List<PersonalInformationTrainer> listPersonalInfoTrainers() {
		// TODO Auto-generated method stub
		return this.TrainerDAO.listPersonalInfoTrainers();
	}

	@Override
	@Transactional
	public PersonalInformationTrainer getPersonalInfoTrainerById(int id) {
		// TODO Auto-generated method stub
		return this.TrainerDAO.getPersonalInfoTrainerById(id);
	}

	@Override
	@Transactional
	public void removePersonalInfoTrainer(int id) {
		// TODO Auto-generated method stub
		this.TrainerDAO.removePersonalInfoTrainer(id);
	}
	

}
