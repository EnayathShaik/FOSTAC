package com.zentech.spring.dao;

import java.util.List;

import com.zentech.spring.hb.model.PersonalInformationTrainer;


public interface TrainerDAO {

			//register Trainer
			
			public void addPersonalInfoTrainer(PersonalInformationTrainer p);
			public void updatePersonalInfoTrainer(PersonalInformationTrainer p);
			public List<PersonalInformationTrainer> listPersonalInfoTrainers();
			public PersonalInformationTrainer getPersonalInfoTrainerById(int id);
			public void removePersonalInfoTrainer(int id);
}
