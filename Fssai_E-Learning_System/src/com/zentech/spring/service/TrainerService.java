package com.zentech.spring.service;

import java.util.List;

import com.zentech.spring.hb.model.PersonalInformationTrainer;


public interface TrainerService {

	
	//Register Trainer
	
		public void addPersonalInfoTrainer(PersonalInformationTrainer p);
		public void updatePersonalInfoTrainer(PersonalInformationTrainer p);
		public List<PersonalInformationTrainer> listPersonalInfoTrainers();
		public PersonalInformationTrainer getPersonalInfoTrainerById(int id);
		public void removePersonalInfoTrainer(int id);
}



